using System;
using System.IO;
using System.Net.Http;
using System.Threading.Tasks;

namespace FileWriter
{
    class Program
    {
       
            static readonly HttpClient client = new HttpClient();
            static async Task Main(string[] args)
            {
                //prompt user for a user
                //http clint to get the page
                //write into a new file
                //launch the file with google chrome

                Console.WriteLine("Enter the url: ");
                string line = Console.ReadLine();
                HttpResponseMessage message = await client.GetAsync(line);
                message.EnsureSuccessStatusCode();

                string resBody = await message.Content.ReadAsStringAsync();

                //Console.WriteLine(resBody);

                using (StreamWriter writer = new StreamWriter("Response.html"))
                {
                    writer.Write(resBody);
                }

                var psi = new System.Diagnostics.ProcessStartInfo() { FileName = "Response.html", UseShellExecute = true };
                System.Diagnostics.Process.Start(psi);


        }
    }
}
