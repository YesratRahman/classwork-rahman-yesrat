using System;
using System.Numerics;
using Utils;

namespace Problem55
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = 0;
            int MaxIterations = 50;
            BigInteger sum = 0; 

            for (BigInteger i = 1; i < 10000; i++)
            {
                sum = i; 
                for (int j = 0; j < MaxIterations; j++) {
                   
                        sum += ReverseNum(sum);
                    if (Util.IsPalindrome(sum))
                    {
                        break; 
                    }
                    else if(j == MaxIterations - 1)
                    {
                        count++; 
                    }

                } 
            }
            Console.WriteLine(count);
        }

        private static BigInteger ReverseNum(BigInteger i)
        {
            BigInteger reverse = 0;
            while (i > 0)
            {
                BigInteger remainder = i % 10;
               
                reverse = reverse * 10 + remainder;
                i /= 10; 

            }
            return reverse;  
        }
    }
}
