using System;
using VendingMachine.Services;

namespace VendingMachine.Controller
{
    public class VendingMachineController
    {
        VendingMachineService _service;
        

        public VendingMachineController(VendingMachineService service)
        {
            _service = service;

        }
        public void Run()
        {
            bool done = false;
            while (!done)
            {
                

            }
        }
    }
}
