using System;

namespace Problem15
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("our answer");
            long[,] grid = new long[21, 21];
            Console.WriteLine(GetRoutes(20, 20, grid));

        }
        private static long GetRoutes(int i, int j, long[,] answers)
        {
            if (answers[i, j] > 0)
            {
                return answers[i, j];
            }

            if (i == 0 || j == 0)
            {
                return 1;
            }

            long leftRoutes = GetRoutes(i, j - 1, answers);
            long upRoutes = GetRoutes(i - 1, j, answers);
            answers[i, j] = upRoutes + leftRoutes;

            return answers[i, j];

        }

    }
} 
