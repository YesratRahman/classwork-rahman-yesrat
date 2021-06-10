using System;
using System.Collections.Generic;

namespace VendingMachine.Models
{
    public class VendingMachine
    {
        public List<Candy> Candies { get; set; }

        public VendingMachine(List<Candy> candies)
        {
            Candies = candies;
        }
    }
}
