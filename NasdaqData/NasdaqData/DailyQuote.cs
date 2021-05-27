using System;
using System.Collections.Generic;
using System.Linq;

namespace NasdaqData
{
    public class DailyQuote
    {
        /* 
         * Date,        Close/Last,     Volume,     Open,       High,       Low
         * 05/26/2021,  $2433.53,     1092819,    $2412.835,  $2442.944, $2412.515

         * DateTime Date
         * decimal Close
         * Ulong Volume
         * decimal Open 
         * decimal High 
         * decimal Low
         * Make them property 
         * 
         */

        public DateTime Date { get; }
        public decimal Close { get; }
        public ulong Volume { get; }
        public decimal Open { get; }
        public decimal High { get; }
        public decimal Low { get; }

        public DailyQuote(DateTime date,
            decimal close,
            ulong volume,
            decimal open,
            decimal high,
            decimal low
            )
        {
            this.Date = date;
            this.Close = close;
            this.Volume = volume;
            this.Open = open;
            this.High = high;
            this.Low = low;
        }

        public DailyQuote(string line)
        {

            string[] values = line.Split(',');

            for (int i = 0; i < values.Length; i++)
            {

                if (i == 0)
                {
                    Date = DateTime.Parse(values[i]);
                }
                else if (i == 1)
                {
                    Close = decimal.Parse(values[i].Substring(1));
                }
                else if (i == 2)
                {
                    Volume = ulong.Parse(values[i]);
                }
                else if (i == 3)
                {
                    Open = decimal.Parse(values[i].Substring(1));
                }
                else if (i == 4)
                {
                    High = decimal.Parse(values[i].Substring(1));
                }
                else if (i == 5)
                {
                    Low = decimal.Parse(values[i].Substring(1));
                }
                else
                {
                    Console.WriteLine("No data found");
                }
            } 
        }
    }
} 
