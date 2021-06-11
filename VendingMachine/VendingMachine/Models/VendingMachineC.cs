using System;
using System.Collections.Generic;

namespace VendingMachine.Models
{
    public class VendingMachineC: IVendingMachineC
    {
        public List<Candy> Candies { get; set; }

        public VendingMachineC(List<Candy> candies)
        {
            Candies = candies;
        }

        public VendingMachineC(VendingMachineC toCopy)
        {
            Candies = new List<Candy>();
            foreach (Candy candy in toCopy.Candies)
            {
                Candies.Add(candy);
            }
        }
    }
}
