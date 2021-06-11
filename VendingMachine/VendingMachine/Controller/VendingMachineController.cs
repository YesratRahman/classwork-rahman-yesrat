using System;
using VendingMachine.Services;

namespace VendingMachine.Controller
{
    public class VendingMachineController
    {
        private IVendingMachineService _service;

        public VendingMachineController(IVendingMachineService vendingMachineService)
        {
            vendingMachineService = _service; 
        }

        public void Run()
        {
            bool completed = false;
            while (!completed)
            {
                _service.ShowCandies(); 
            }
        }
    }
}
