using System;
using System.Numerics;

namespace Problem16
{
    class Program
    {
        static void Main(string[] args)
        {
            BigInteger number = 1;
            int result = 0; 
            for(int i = 1; i <= 1000; i++)
            {
                // 2 ^ 0 = 1
                //2 ^ 1 = 2 = 2 ^ 0 * 2 
                //2 ^ 2 = 4 = 2 ^ 1 * 2 
                //2 ^ 3 = 2 ^ 2 * 2

                //2 ^ 1000 = 2 ^ 999 * 2 



                number *= 2; 
            }

            // 573 % 10 = 3
            // 573 / 10 = 57

            while(number > 0)
            {
                result += (int) (number % 10);
                number =  number / 10; 

            }

            Console.WriteLine(result);
        }
    }
}
