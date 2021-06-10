using System;
using VendingMachine.Daos;

namespace VendingMachine.Services
{
    public class VendingMachineService : IVendingMachineFileDao
    {
        private readonly IVendingMachineFileDao _vendingMachineFileDao;
        public VendingMachineService(VendingMachineFileDao vendingMachineFileDao)
        {
            _vendingMachineFileDao = vendingMachineFileDao; 
        }

       
    }
}
