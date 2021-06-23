using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Numerics;

namespace Problem22
{
    class Program
    {
        static void Main(string[] args)
        {
            using(StreamReader reader = new StreamReader("../../../p022_names.txt"))
            {
                string text = reader.ReadToEnd();

                List<string> names = new List<string>();
                string[] splitTexts = text.Split(",");
                names.AddRange(splitTexts.Select(n => n.Replace("\"", "" )));
                names.Sort();
                long total = 0;
             
                for(int i = 0; i < names.Count; i++)
                {
                    string name = names[i]; 
                    int score = GetScore(name);

                    int position = i + 1;

                    total += score * position;
                }
                Console.WriteLine(total);
            }
        }

        private static int GetScore(string name)
        {
           int score = name.Select(c => c - 'A' + 1).Sum();
            return score; 

        }
    }
}
