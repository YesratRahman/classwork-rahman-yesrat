using System;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
   

    public interface IVendingMachineFileDao
    {
        public VendingMachineC VendingMachine { get; }
        public string ReadFile { get; set; }

        public VendingMachineC GetVendingMachineFile(); 
    }
}
