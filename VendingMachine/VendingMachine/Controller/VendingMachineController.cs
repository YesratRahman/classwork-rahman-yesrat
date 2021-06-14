using System;
using VendingMachine.Exceptions;
using VendingMachine.Models;
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
                while (money > 0.0m)
                {
                    int choice = _service.ShowCandies(_service.GetAllCandies()) - 1;
                    try
                    {
                        Console.WriteLine("You have chosen to buy " + _service.GetAllCandies()[choice].Name);
                        _service.BuyCandies(_service.GetAllCandies()[choice], money);
                        money = 0;

                    }
                    catch (InsufficientFundsException ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                    catch (ItemOutOfStockException e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }
    }
}
