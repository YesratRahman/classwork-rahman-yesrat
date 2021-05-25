using System;

namespace DayTime
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.Write("Enter a date (yyyy, MM/dd): " );
            
            string userInput = Console.ReadLine();

            DateTime userDate = DateTime.ParseExact(userInput, "yyyy, MM/dd", null);

            DayOfWeek userEnteredDay = userDate.DayOfWeek;

            if(userEnteredDay == DayOfWeek.Friday)
            {
                userDate = userDate.AddDays(7);
            

            }
            else if(userEnteredDay == DayOfWeek.Saturday)
            {
                userDate = userDate.AddDays(6);

            }
            else if (userEnteredDay == DayOfWeek.Sunday)
            {
                userDate = userDate.AddDays(5);

            }
            else if (userEnteredDay == DayOfWeek.Monday)
            {
                userDate = userDate.AddDays(4);

            }
            else if (userEnteredDay == DayOfWeek.Tuesday)
            {
                userDate = userDate.AddDays(3);

            }
            else if (userEnteredDay == DayOfWeek.Wednesday)
            {
                userDate = userDate.AddDays(2);

            }
            else
            {
                userDate = userDate.AddDays(1);

            }


            Console.WriteLine("The next Friday is : " + userDate); 

        }


    }
}
