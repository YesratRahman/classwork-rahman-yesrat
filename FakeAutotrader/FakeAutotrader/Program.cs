using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace FakeAutotrader
{
    class Program
    {
        static readonly HttpClient _client = new HttpClient();
        static readonly Mutex _mutexLock = new Mutex();
        static readonly Dictionary<string, List<double>> _stockPrices = new Dictionary<string, List<double>>();
        static void Main(string[] args)
        {
            //Fake Autotrader

            //As a user, I should be able to enter a list of stock symbols to
            //watch(just pressing enter to indicate I'm done with a blank line).

            //As a user, I should be able to see periodic updates to prices
            //(once a minute for each monitored stock).

            //As a user, whenever a stock crosses above the median price observed so far,
            //I should get a message to sell that stock.

            //As a user, whenever a stock crosses below the median price observed so far,
            //I should get a message to buy that stock.

            List<string> stocks = new List<string>();
            bool completed = false;
            List<Task> tasks = new List<Task>();

            Console.WriteLine("Enter one or more stocks you want to keep track of: ");
            while (!completed)
            {
                string symbol = Console.ReadLine().ToUpper();
                if (symbol == "")
                {
                    break;
                }
                stocks.Add(symbol);
            }
            foreach (string stock in stocks)
            {
                tasks.Add(Task.Factory.StartNew(
                    () => GetStockPrices(stock)).Unwrap());
            }

            Task.WaitAll(tasks.ToArray());
        }



        static async Task GetStockPrices(string stock)
        {
            bool found = false;
            while (!found)
            {
                HttpResponseMessage res = await _client.GetAsync("https://finnhub.io/api/v1/quote?symbol=" + stock + "&token=c2t5i4aad3i9opckig60");
                res.EnsureSuccessStatusCode();
                string messageBody = await res.Content.ReadAsStringAsync();
                Match match = Regex.Match(messageBody, @"(?<={""c"":)[^,]+");

                double price = double.Parse(match.ToString());

                Console.WriteLine(stock + " Price: " + "$" + price + " " + DateTime.Now);

                _mutexLock.WaitOne();

                if (_stockPrices.ContainsKey(stock))
                {
                    if (_stockPrices.GetValueOrDefault(stock).Count > 2)
                    {

                        double medianPrice;
                        List<double> prices = _stockPrices.GetValueOrDefault(stock);
                        prices.Sort();
                        if (prices.Count % 2 == 0)
                        {
                            medianPrice = (prices[(prices.Count / 2) - 1] + prices[prices.Count / 2]) / 2;
                        }
                        else
                        {
                            medianPrice = prices[prices.Count / 2];
                        }

                        if (price > medianPrice)
                        {
                            Console.WriteLine("Sell " + stock + " for " + " price");
                        }
                        else if (price < medianPrice)
                        {
                            Console.WriteLine("Buy " + stock + " for " + " price");
                        }
                    }
                    _stockPrices.GetValueOrDefault(stock).Add(price);
                }
                else
                {
                    _stockPrices.Add(stock, new List<double> { price });
                }
                _mutexLock.ReleaseMutex();

                await Task.Delay(50000);
            }

        }

    }
}  
