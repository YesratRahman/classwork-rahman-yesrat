using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace FileWriter
{
    class Program
    {

        public static readonly HttpClient client = new HttpClient();
        public static HashSet<string> _processedUrls = new HashSet<string>();
        public static Mutex _mutexLock = new Mutex();
        public static Queue<string> _leftUrls = new Queue<string>();
        public static int _count = 0;

        public Dictionary<string, HashSet<string>> _urlDic = new Dictionary<string, HashSet<string>>(); 
        static async Task Main(string[] args)
        {
            //prompt user for a user
            //http clint to get the page
            //write into a new file
            //launch the file with google chrome
            //using (StreamWriter writer = new StreamWriter("Response.html"))
            //{
            //    writer.Write(resBody);
            //}

            //var psi = new System.Diagnostics.ProcessStartInfo() { FileName = "Response.html", UseShellExecute = true };
            //System.Diagnostics.Process.Start(psi);


            Console.WriteLine("Enter the url: ");
            string url = Console.ReadLine();
            _mutexLock.WaitOne(); 
            _leftUrls.Enqueue(url);
            _mutexLock.ReleaseMutex(); 
            await Dispatch();

            //search a url for words





        }

        private static void FindWords(string pageContent)
        {

            string[] words = Regex.Split(pageContent, "\\W");


        }

        private static async Task Dispatch()
        {
            while (_count < 500)
            {
                _mutexLock.WaitOne();

                if (_leftUrls.Count != 0)
                {
                    string url = _leftUrls.Dequeue();
                    Task.Factory.StartNew(() => getUrls(url));
                    _count++;
                }
                _mutexLock.ReleaseMutex();
                await Task.Delay(1000);
            }
        }

        private static async Task getUrls(string url)
        {
            Console.WriteLine(url);
            HttpResponseMessage message = await client.GetAsync(url);
            message.EnsureSuccessStatusCode();

            string resBody = await message.Content.ReadAsStringAsync();

            FindWords(resBody); 

            Regex r = new Regex(@"(?<=href=\W*""?)[^""?']+");

            MatchCollection matches = r.Matches(resBody);


            string checkMatch;
            foreach (Match match in matches)
            {

                checkMatch = match.Value;
                Regex rx = new Regex(@"^\/[^*]+");
                if (rx.IsMatch(match.Value))
                {
                    checkMatch = url.Substring(0, url.Length - 1) + match.Value;
                }
                if (_processedUrls.Add(checkMatch))
                {
                    _mutexLock.WaitOne(); 
                    _leftUrls.Enqueue(checkMatch);
                    _mutexLock.ReleaseMutex(); 
                }
                
                //Console.WriteLine(checkMatch);
            }


        }
    }
}
