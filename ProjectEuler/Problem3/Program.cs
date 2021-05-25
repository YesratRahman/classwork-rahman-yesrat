using System;
using System.Numerics;
using Utils;

namespace Problem3
{
    class Program
    {
        static void Main(string[] args)
        {

            BigInteger input = 600851475143;

            BigInteger squareRoot = Util.GetSquareRoot(input);

            BigInteger biggestLowFactor = -1; 

            bool found = false;

            for(BigInteger i = 1; i<= squareRoot; i++)
            {
                if(input % i == 0)
                {
                    BigInteger bigFactor = input / i;

                    if (Util.IsPrime(bigFactor))
                    {
                        Console.WriteLine(bigFactor);
                        found = true;
                        //break;
                    }
                    else if (Util.IsPrime(i) && i > biggestLowFactor)
                    {
                        biggestLowFactor = i;

                    }
                }
            }
            if (!found)
            {
                Console.WriteLine(biggestLowFactor);
            }

        }
    }
}
