using System;
using System.Collections.Generic;
using Utils;

namespace Problem10
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> primes = new List<int>();

            long sum = 2;
            for(int i = 3; i < 2000000; i += 2)
            {
                if (i % 1000 == 0)
                    Console.WriteLine(i); 
                if (Util.IsPrime(primes, i)){
                    primes.Add(i); 
                    sum += i; 
                }

            }
            Console.WriteLine(sum);

            //The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
            //Find the sum of all the primes below two million.
            //Answer  = 142913828922

        }
    }
}
