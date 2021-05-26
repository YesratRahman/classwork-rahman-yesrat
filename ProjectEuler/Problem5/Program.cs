using System;

namespace Problem5
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 1; i < int.MaxValue; i++)
            {
                bool isDivisible = true;
                for (int j = 20; j > 10; j--)
                {
                    if (i % j != 0)
                    {
                        isDivisible = false;
                        break;
                    }
                }

                if (isDivisible)
                {
                    Console.WriteLine(i);
                    break;
                }
            }
        }
    }
}
