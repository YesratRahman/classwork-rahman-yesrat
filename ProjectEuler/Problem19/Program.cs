using System;

namespace Problem19
{
    class Program
    {
        static void Main(string[] args)
        {


            // You are given the following information, but you may prefer to do some research for yourself.

            // 1 Jan 1900 was a Monday.
            // Thirty days has September,
            // April, June and November.
            // All the rest have thirty - one,
            // Saving February alone,
            // Which has twenty - eight, rain or shine.
            // And on leap years, twenty - nine.
            // A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
            // How many Sundays fell on the first of the month during the twentieth century(1 Jan 1901 to 31 Dec 2000) ?


            int firstSundays = 0;

            //DateTime start = new DateTime(1901, 1, 1);
            //DateTime newDate = start.AddDays(31).AddDays(31);

            //for(int month = 0; month < 1200; month++)
            //{
            //    if(start.DayOfWeek == DayOfWeek.Sunday)
            //    {
            //        firstSundays++; 
            //    }
            //    start = start.AddMonths(1); 
            //}

            for(DateTime current = new DateTime(1901, 1, 1); current <= new DateTime(2000, 12, 1); current = current.AddMonths(1))
            {
                if (current.DayOfWeek == DayOfWeek.Sunday)
                {
                    firstSundays++;
                }
            }

            Console.WriteLine(firstSundays);

        }
    }
}
