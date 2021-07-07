using System;
using System.Collections.Generic;
using System.IO;
using Utils; 

namespace Problem59
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamReader reader = new StreamReader("../../../p059_cipher.txt")) 
            {
                string text = reader.ReadToEnd();
                List<int> asciiNums = new List<int>();
                string[] splitTexts = text.Split(",");

                foreach(string str in splitTexts)
                {
                    asciiNums.Add(int.Parse(str));
                    //Console.WriteLine(str);
                }
                string alpha = "abcdefghijklmnopqrstuvwxyz";
                char[] alphabets = alpha.ToCharArray(); 

                for(int i = 0; i < alphabets.Length; i++)
                {
                    for(int j = 0; j < alphabets.Length; j++)
                    {
                        for (int k = 0; k < alphabets.Length; k++)
                        {
                            string possPass =(alphabets[i] + alphabets[j] + alphabets[k]).ToString();
                            int count = 0;
                            string plainText = "";
                            bool valid = true; 
                            while(count < splitTexts.Length)
                            {
                                if(count < splitTexts.Length)
                                {
                                    int xor = (alphabets[i] ^ int.Parse(splitTexts[count]));
                                    if (xor > 31 && xor < 127)
                                    {
                                        plainText += Convert.ToChar(xor);
                                    }
                                    else
                                    {
                                        valid = false; 
                                    }
                                }
                                if (count+1 < splitTexts.Length)
                                {
                                    int xor = (alphabets[j] ^ int.Parse(splitTexts[count + 1 ]));
                                    if (xor > 31 && xor < 127)
                                    {
                                        plainText += Convert.ToChar(xor);
                                    }
                                    else
                                    {
                                        valid = false;
                                    }

                                }
                                if (count+2 < splitTexts.Length)
                                {
                                    int t = int.Parse(splitTexts[count + 2]); 
                                    int xor = (alphabets[k] ^ t );
                                    if (xor > 31 && xor < 127)
                                    {
                                        plainText += Convert.ToChar(xor);
                                    }
                                    else
                                    {
                                        valid = false;
                                    }

                                }
                                count += 3; 


                            }
                            if (valid)
                            {
                                Console.WriteLine(Util.AsciiSum(plainText )) ;
                                Console.WriteLine(plainText);
                                Console.ReadLine();

                            }


                        }
                    }
                }

                
                //36 // abc // 
                //22 
                //80


            }
        }
    }
}
