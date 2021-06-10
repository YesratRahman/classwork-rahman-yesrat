using System;
using System.Collections.Generic;

namespace VendingMachine.Models
{
    
        public interface IVendingMachine
        {
            public List<Candy> Candies { get; set; }
        }
}

