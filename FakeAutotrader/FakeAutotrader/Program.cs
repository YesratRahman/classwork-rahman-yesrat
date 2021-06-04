using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

namespace FakeAutotrader
{
    class Program
    {
        public static readonly HttpClient _client = new HttpClient();
        public static Mutex _mutexLock = new Mutex();

        static async Task Main(string[] args)
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

            Console.WriteLine("Enter enter the list of stock symbols that you want to watch: ");
            while (true)
            {
                string symbol = Console.ReadLine().ToLower();
                if (symbol == "")
                {
                    break;
                }
                stocks.Add(symbol);
            }
        }

        static async Task GetStock(string ticker)
        {
            HttpResponseMessage reponse = await _client.GetAsync($"https://finnhub.io/api/v1/quote?symbol={ticker}&token=c2t5i4aad3i9opckig60");
            reponse.EnsureSuccessStatusCode();


            string resBody = await reponse.Content.ReadAsStringAsync();
            _mutexLock.WaitOne();
            Console.WriteLine(resBody);
            _mutexLock.ReleaseMutex();
            await Task.Delay(1000); 
        }
    }
} 
    
