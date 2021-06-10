using System;
namespace VendingMachine.Services

{
    public class VendingMachineService: IVendingMachineService
    {
        private readonly IVendingMachineService _vendingMachineDao; 
        public VendingMachineService(IVendingMachineService vendingMachineDao)
        {
            _vendingMachineDao = vendingMachineDao; 
        }
    }
}
