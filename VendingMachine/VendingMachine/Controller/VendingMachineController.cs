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
                string inputedMoney;
                decimal money;

                System.Console.Write("Please input the money allocated for candy: ");
                inputedMoney = System.Console.ReadLine();
                money = decimal.Parse(inputedMoney);

                int choice = _service.ShowCandies();
                    //purchase candy
                    //give change back 
                

                break; 
            }
        }
    }
}
