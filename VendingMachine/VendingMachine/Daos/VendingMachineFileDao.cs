using System;
using System.Collections.Generic;
using System.IO;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
    public class VendingMachineFileDao : IVendingMachineFileDao
    {
        public VendingMachineC VendingMachineC { get; }
        public string ReadFile { get; set; }

        public VendingMachineC VendingMachine => throw new NotImplementedException();

        public VendingMachineFileDao( )
        {
           
            List<Candy> candies = new List<Candy>();

            using (StreamReader reader = new StreamReader("../../../Candies.txt"))
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
                VendingMachineC = new VendingMachineC(candies);
            }
        }


        public VendingMachineC GetVendingMachineFile()
        {
            return new VendingMachineC(VendingMachineC);
        }

       
    }
}
