using System;
using System.IO;

namespace Problem83
{
    class Program
    {
        static void Main(string[] args)
        {
            long[,] grid = new long[80, 80];
            using (StreamReader reader = new StreamReader("../../../matrix.txt"))
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

                GetMinPath(grid,80,80); 
            }
        }

        private static void GetMinPath(long[,] grid, long row, long col ) 
        {
            long[,] copyGrid = new long[80, 80]; 
            for(int i = 79; i < 80; i--)
            {
                for(int j = 79; j < 80; j--)
                {
                    if(i == 79 && j == 79)
                    {
                        copyGrid[i, j] = grid[i, j];
                    }
                    else if (i == 79)
                    {
                        copyGrid[i, j] = grid[i, j] + copyGrid[i, j - 1]; //left
                        if(j != 79)
                        {
                            copyGrid[i, j] = grid[i, j] + copyGrid[i, j + 1]; //right
                        }
                        copyGrid[i, j] = grid[i, j] + copyGrid[i - 1, j]; //up 

                    }
                    else if (j == 79)
                    {
                        copyGrid[i, j] = grid[i, j] + copyGrid[i - 1, j]; //left 
                        if(i != 79)
                        {
                            copyGrid[i, j] = grid[i, j] + copyGrid[i + 1, j]; //down 
                        }
                        if(i != 0)
                        {
                            copyGrid[i, j] = grid[i, j] + copyGrid[i - 1, j]; //right
                        }   
                    }

                    
                }
            }

            
        }
    }
} 
