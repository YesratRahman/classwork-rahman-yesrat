using System;
using System.IO;

namespace Problem81
{
    class Program
    {
        static void Main(string[] args)
        {
            long[,] grid = new long[80, 80];
            using (StreamReader reader = new StreamReader("../../../p081_matrix.txt"))
            {
                int rowNum = 0;
                string line = null;
                while ((line = reader.ReadLine()) != null)
                {
                    string[] text = line.Split(',');
                    for (int i = 0; i < 80; ++i)
                    {
                        grid[rowNum, i] = long.Parse(text[i]);
                    }
                    rowNum++;
                }




            }
            long[,] chart = new long[80, 80];
            for (int i = 0; i < 80; ++i)
            {
                for (int j = 0; j < 80; ++j)
                {
                    if (i == 0 && j == 0)
                    {
                        chart[i, j] = grid[i, j];
                    }
                    else if (i == 0)
                    {
                        chart[i, j] = grid[i, j] + chart[i, j - 1];
                    }

                    else if (j == 0)
                    {
                        chart[i, j] = grid[i, j] + chart[i - 1, j];
                    }
                    else
                    {
                        chart[i, j] = grid[i, j] + Math.Min(chart[i - 1, j], chart[i, j - 1]);
                    }

                }
            }



            Console.WriteLine(chart[79, 79]);
        }




    }
} 