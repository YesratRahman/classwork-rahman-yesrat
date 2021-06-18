using System;
using System.Collections.Generic;
using Utils;
namespace Problem24
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> allPermutations = new List<string>();
            List<string> availableNums = new List<string> { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

            string perm = "";

            GeneratePermutations(allPermutations, perm, availableNums);

            Console.WriteLine(allPermutations[999999]);

        }
        public static void GeneratePermutations(List<string> allPermutations, string currNum, List<string> availableNums)
        {
            //currNum = 0
            //currNum = 01
            //currNum = 012
            //currNum = 0123
            if (availableNums.Count == 0)
            {
                allPermutations.Add(currNum);
            }
            else
            {
                for (int i = 0; i < availableNums.Count; i++)
                {
                    string addString = availableNums[i];

                    availableNums.RemoveAt(i);

                    GeneratePermutations(allPermutations, currNum + addString, availableNums);

                    availableNums.Insert(i, addString);
                }
            }

        }
    }
} 
 
