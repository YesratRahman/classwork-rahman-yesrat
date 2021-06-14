using System;
using System.Collections.Generic;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
   

    public interface IVendingMachineFileDao
    {
        public string ReadFile { get; set; }

        void RemoveCandy(string name);
        public List<Candy> GetAllCandies(); 

    }
}
