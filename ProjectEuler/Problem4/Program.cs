using System;
using Utils;



namespace Problem4



{
    class Program
    {
        static void Main(string[] args)
        {
            //bool palindrome = Util.IsPalindrome(9009);
            //Console.WriteLine(palindrome);
            Console.WriteLine("START HERE");
            int largestPal = int.MinValue;



            for (int i = 999; i >= 100; i--)
            {



                for (int j = 999; j >= 100; j--)
                {
                    int mult = i * j;
                    if (Util.IsPalindrome(mult) && mult > largestPal)
                    {
                        largestPal = mult;
                        Console.WriteLine(largestPal);
                    }


                }
            }





        }
    }
}
