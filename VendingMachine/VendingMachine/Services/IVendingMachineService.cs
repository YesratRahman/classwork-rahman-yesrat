using System;
using System.Collections.Generic;
using VendingMachine.Models;

namespace VendingMachine.Services
{
    public interface IVendingMachineService
    {
        public int ShowCandies(List<Candy> candies);
        public decimal GetUserMoney();
        public List<Candy> GetAllCandies();
        public void BuyCandies(Candy candy, decimal money);
        public Change GiveChanges(decimal costProduct, decimal moneyGiven);



    }
}
