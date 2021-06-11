using System;
using System.Collections.Generic;
using VendingMachine.Daos;
using VendingMachine.Models;

namespace VendingMachine.Services
{
    public class VendingMachineService : IVendingMachineService
    {
        private readonly IVendingMachineFileDao _vendingMachineFileDao;

        public VendingMachineService(IVendingMachineFileDao fileDao)
        {
            _vendingMachineFileDao = fileDao;
        }

        public int ShowCandies()
        {

            int choice = -1;
            bool chosen = false;
            List<Candy> candies = GetCandies();

            Console.WriteLine("Choose a number to buy candies:\n");
            while (!chosen)
            {
                foreach (Candy candy in GetCandies())
                {
                    int choiceIndex = GetCandies().IndexOf(candy);
                    Console.WriteLine(choiceIndex + ": " + candy.Quantity + " " + candy.Name + " (" + "$" + candy.Price + " each)");
                    Console.WriteLine();
                }
                chosen = int.TryParse(Console.ReadLine(), out choice);
                if (chosen) chosen = choice > 0 && choice < candies.Count;
            }

            return choice;


        }
        public List<Candy> GetCandies()
        {
            return _vendingMachineFileDao.GetVendingMachineFile().Candies;
        }

        public void ChooseCandies()
        {
            throw new NotImplementedException();
        }

        public void BuyCandies(Candy candy, decimal money)
        {
            throw new NotImplementedException();
        }
    }
} 
