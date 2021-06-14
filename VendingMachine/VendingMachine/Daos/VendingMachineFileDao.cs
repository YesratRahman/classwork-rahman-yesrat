using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
    public class VendingMachineFileDao : IVendingMachineDao
    {
        public string ReadFile { get; set; }

        public VendingMachineFileDao() : this("../../../../VendingMachine/Candies.txt")
        {

        }
        public VendingMachineFileDao(string filePath)
        {
            ReadFile = filePath;
        }

        public void UpdateCandy(string name)
        {
            var candies = GetAllCandies()
                .Select(candy => candy.Name == name ?
                new Candy(candy.Name, candy.Quantity - 1, candy.Price) : candy)
                .ToList();
            UpdateFile(candies);
        }

        private void UpdateFile(List<Candy> candies)
        {
            string line = "";
            foreach (Candy candy in candies)
            {
                line += candy.ToString() + "\n";
            }
            File.WriteAllText(ReadFile, line);
        }

        public List<Candy> GetAllCandies()
        {
            List<Candy> candies = new List<Candy>();
            using (StreamReader reader = new StreamReader(ReadFile))
            {
                string line = null;
                while ((line = reader.ReadLine()) != null)
                {
                    string[] lines = line.Split(",");
                    string name = lines[0];
                    int quantity = int.Parse(lines[1]);
                    decimal price = decimal.Parse(lines[2]);
                    Candy newCandy = new Candy(name, quantity, price);
                    candies.Add(newCandy);
                }
                return candies;
            }
        }
    }
}
