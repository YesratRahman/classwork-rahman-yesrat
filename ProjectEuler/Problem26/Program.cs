using System;
using System.Collections.Generic;

namespace Problem26
{
    class Program
    {
        static void Main(string[] args)
        {
            int maxDenom = 2;
            int maxCycle = 0;
            for (int denom = 2; denom < 1000; denom++)
            {
                HashSet<int> remainders = new HashSet<int>();
                List<int> allDigits = new List<int>(); 
                int remainder = 1;
                while (remainder != 0)
                {
                    int value = remainder / denom;
                    remainder = (remainder - (denom * value)) * 10;
                    allDigits.Add(remainder); 
                    if (!remainders.Add(remainder))
                    {
                        if (remainders.Count > maxCycle)
                        {
                            maxDenom = denom;
                            //  maxCycle = remainders.Count;
                            maxCycle = allDigits.Count - allDigits.IndexOf(allDigits[allDigits.Count - 1]) - 1; 
                        }
                        break;
                    }
                }
            }
            Console.WriteLine("Max denom is " + maxDenom + " with a cycle length of " + maxCycle);
        }
    }
}
