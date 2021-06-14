using System;
using VendingMachine.Services;

namespace VendingMachine.Controller
{
    public class VendingMachineController
    {
        private IVendingMachineService _service;

        public VendingMachineController(IVendingMachineService machineService)
        {
             _service = machineService; 
        }

        public void Run()
        {
            bool completed = false;
            while (!completed)
            {
                Console.WriteLine("-----------------------------");
                Console.WriteLine("Welcome to Vending Machine");
                decimal money = _service.GetUserMoney();

                while(money > 0.0m)
                {
                    //int choice = _service.ShowCandies() - 1;
                    //buy the candy
                    //_service.BuyCandies(_service.GetCandies()[choice], money) ;

                    //give change back 
                    _service.GiveChanges(10m, money);
                    
                }

               


                break; 
            }
        }
    }
}
