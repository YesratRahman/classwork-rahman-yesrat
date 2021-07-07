using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Problem79
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamReader reader = new StreamReader("../../../keylog.txt"))
            {

                HashSet<string> passcodes = new HashSet<string>();
                string[] copy;
                string line = null;
                while ((line = reader.ReadLine()) != null)
                {
                    passcodes.Add(line);
                }
                string possiblePass = "";
                copy = passcodes.ToArray();

                foreach (string code in passcodes)
                {
                    bool valid = true;

                    char nextDigit = code[0];
                    foreach (string codeStr in passcodes)
                    {
                        for(int i = 1; i < codeStr.Length; i++)
                        {
                           
                            if (nextDigit == codeStr[i])
                            {
                                valid = false;
                            }
                        }
                    }

                    if (valid && !possiblePass.Contains(nextDigit))
                    {
                        possiblePass += nextDigit;
                        for (int i = 0; i < copy.Length; i++)
                        {
                            if (copy[i].Contains(nextDigit))
                            {
                                copy[i] = copy[i].Remove(0, 1);
                                copy = copy.Where(c => c.Length == 1).ToArray(); 
                            }

                        }

                    }



                }


                Console.WriteLine(possiblePass);

            }
        }
    }
}