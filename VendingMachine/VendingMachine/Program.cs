using System;
using VendingMachine.Controller;
using VendingMachine.Services;

namespace VendingMachine
{
    class Program
    {
        static void Main(string[] args)
        {


            VendingMachineController machineController = new VendingMachineController
                (new VendingMachineService(new VendingMachineDao)); 
        }
    }
}
