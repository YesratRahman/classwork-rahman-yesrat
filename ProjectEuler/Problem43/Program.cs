using System;
using System.Collections.Generic;
using Utils;

namespace Problem43
{
    class Program
    {
        static void Main(string[] args)
        {

                List<string> allNums = new List<string>();
                List<string> available = new List<string> { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
                List<int> primes = new List<int> { 2, 3, 5, 7, 11, 13, 17 };
                string currNum = "";



                Util.GeneratePermutations(allNums, currNum, available);





                long answer = 0;



                string test = "1406357289";




                for (int i = 0; i < allNums.Count; i++)
                {
                    if (allNums[i] == test)
                    {



                    }
                    bool meetsConditions = true;
                    for (int j = 0; j < 8; j++)
                    {
                        if (j != 0)
                        {
                            string sub = allNums[i].Substring(j, 3);
                            int subNum = int.Parse(sub);



                            if (subNum % primes[j - 1] != 0)
                            {
                                meetsConditions = false;
                            }





                        }







                    }
                    if (meetsConditions)
                    {
                        answer += long.Parse(allNums[i]);
                    }
                }




                Console.WriteLine(answer);
            }
        }
    }












