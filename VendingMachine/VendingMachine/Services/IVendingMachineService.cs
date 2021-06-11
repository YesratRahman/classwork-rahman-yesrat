using System;
using System.Collections.Generic;
using VendingMachine.Models;

namespace VendingMachine.Services
{
    public interface IVendingMachineService
    {
        public int ShowCandies();
        public List<Candy> GetCandies();
        void ChooseCandies();
        void BuyCandies(Candy candy, decimal money);
    }
}
