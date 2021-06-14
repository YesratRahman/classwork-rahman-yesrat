using System;
using System.Collections.Generic;
using VendingMachine.Models;

namespace VendingMachine.Services
{
    public interface IVendingMachineService
    {
        public int ShowCandies();
        void BuyCandies(Candy candy, decimal money);
        public decimal GetUserMoney();
        public List<Candy> GetCandies();
        public Change GiveChanges(decimal costProduct, decimal moneyGiven);


    }
}
