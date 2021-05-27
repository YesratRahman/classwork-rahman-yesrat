using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace NasdaqData
{
    internal class Program
    {
        static void Main(string[] args)
        {

            /*
            * group data by year
            * get standard deviation for:
            * open
            * high
            * low
            * close
            * output should be a dictionary that maps from year to a list of
            * answers for that year
            * you could also make a class to hold the result for the year
            */

            //Group data by year, get standard deviation for
            // open, high, low, close
            //output should be a dictionary that maps from year to a list of
            //answers for that year
            //Could also make a class to hold the result for the year
            //Create list to store all the quotes

            List<DailyQuote> allQuotes = new List<DailyQuote>();
            using (StreamReader reader = new StreamReader("../../../Data.csv"))
            {
                string headerLine = reader.ReadLine();
                string line = null;

                while ((line = reader.ReadLine()) != null)
                {
                    DailyQuote quote = new DailyQuote(line);
                    allQuotes.Add(quote);
                }
            }

            var groupByYear = GroupByYear(allQuotes);

            Dictionary<int, List<decimal>> result = new Dictionary<int, List<decimal>>();

            foreach (int year in groupByYear.Keys)
            {
                List<decimal> closes = new List<decimal>();
                List<decimal> opens = new List<decimal>();
                List<decimal> highs = new List<decimal>();
                List<decimal> lows = new List<decimal>();

                foreach (DailyQuote quote in groupByYear[year])
                {
                    closes.Add(quote.Close);
                    opens.Add(quote.Open);
                    highs.Add(quote.High);
                    lows.Add(quote.Low);
                }
                decimal stDClose = StdDev(closes);
                decimal stDOpen = StdDev(opens);
                decimal stDHigh = StdDev(highs);
                decimal stDLow = StdDev(lows);
                List<decimal> answers = new List<decimal>();
                answers.Add(Math.Round(stDClose));
                answers.Add(Math.Round(stDOpen));
                answers.Add(Math.Round(stDHigh));
                answers.Add(Math.Round(stDLow));
                result.Add(year, answers);
            }

            foreach (int year in result.Keys)
            {
                Console.WriteLine(
                    "For Year " + year + ":" + " Close " + result[year][0] +
                    " Open " + result[year][1] + " High " + result[year][2] +
                    " Low " + result[year][3]);
            }
        }

        private static Dictionary<int, List<DailyQuote>> GroupByYear(List<DailyQuote> allQuotes)
        {
            Dictionary<int, List<DailyQuote>> groupByYear = new Dictionary<int, List<DailyQuote>>();
            foreach (DailyQuote quote in allQuotes)
            {
                if (!groupByYear.ContainsKey(quote.Date.Year))
                {
                    groupByYear.Add(quote.Date.Year, new List<DailyQuote>(new DailyQuote[] { quote }));
                }
                else
                {
                    groupByYear.GetValueOrDefault(quote.Date.Year).Add(quote);
                }
            }
            return groupByYear;
        }



        public static decimal StdDev(List<decimal> nums)
        {
            decimal mean = 0;
            foreach (decimal num in nums)
            {
                mean += num;
            }
            mean /= nums.Count;

            List<decimal> output = new List<decimal>();
            foreach (decimal num in nums)
            {
                decimal square = num - mean;
                output.Add(square * square);
            }
            decimal difference = 0;
            foreach (decimal num in output)
            {
                difference += num;
            }
            difference /= output.Count;
            return (decimal)Math.Sqrt((double)difference);
        }
    }
}
