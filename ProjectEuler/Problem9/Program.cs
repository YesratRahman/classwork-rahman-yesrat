using System;

namespace Problem9
{
    class Program
    {
        static void Main(string[] args)
        {
            //            A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

            //a2 + b2 = c2
            //For example, 32 + 42 = 9 + 16 = 25 = 52.

            //There exists exactly one Pythagorean triplet for which a +b + c = 1000.
            //Find the product abc.

            
            int product = 0;

            //c = 1000 - a - b
            // 0 < a, b, c< 1000
            // 
            
            for (int a = 1; a < 1000; a++)
            {
                for(int b = 1; b < 1000; b++)
                {
                    int c = 1000 - a - b;
                    if( (a * a) + (b * b) == (c* c))
                    {
                        product = a * b * c;
                    }
                }

            }

            Console.WriteLine("The product is : " + product); 

        }
    }
}
