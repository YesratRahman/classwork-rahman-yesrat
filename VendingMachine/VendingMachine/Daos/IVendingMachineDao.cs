using System;
using System.Collections.Generic;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
    public interface IVendingMachineDao
    {
        void UpdateCandy(string name);
        public List<Candy> GetAllCandies(); 

    }
}
