using System;
using System.Collections.Generic;
using Utils;

namespace Problem27
{
    class Program
    {
        static void Main(string[] args)
        {

            // n*n + an + b = prime number
            // if n = 0, b = prime number

            List<int> bPrimes = new List<int>();
            int maxLength = 0;

            (int, int) coefficient = (0, 0); 

            for (int i = 2; i <= 1000; i++)
            {
                if (Util.IsPrime(i))
                {
                    bPrimes.Add(i); 
                }
            }

            foreach (int b in bPrimes)
            {
                for (int a = -999; a <= 999; a++)
            {
                
                    int n = 0;
                    bool foundNonPrime = false;
                    int count = 0; 

                    while(!foundNonPrime)
                    {
                        if(Util.IsPrime((n*n) + (a*n) + b))
                        {
                            count++;
                        }
                        else
                        {
                            foundNonPrime = true;
                           
                        }
                        n++;
                    }
                    if(count > maxLength)
                    {
                        coefficient = (a, b);
                        maxLength = count; 
                    }

                }
            }
            Console.WriteLine("Coefficient product is " + (coefficient.Item1 * coefficient.Item2));

        }
    }
}