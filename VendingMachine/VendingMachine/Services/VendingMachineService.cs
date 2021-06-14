using System;
using System.Collections.Generic;
using VendingMachine.Daos;
using VendingMachine.Exceptions;
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




        public List<Candy> GetCandies()
        {
            return _vendingMachineFileDao.GetAllCandies();
        }


        public int ShowCandies()
        {

            int choice = -1;
            bool chosen = false;
            List<Candy> candies = _vendingMachineFileDao.GetAllCandies();

            Console.WriteLine("Choose a number to buy candies:\n");
            while (!chosen)
            {
                foreach (Candy candy in _vendingMachineFileDao.GetAllCandies()) 
                {
                    int choiceIndex = _vendingMachineFileDao.GetAllCandies().IndexOf(candy);
                    Console.WriteLine(choiceIndex + ": " + candy.Quantity + " " + candy.Name + " (" + "$" + candy.Price + " each)");
                    Console.WriteLine();
                }
                chosen = int.TryParse(Console.ReadLine(), out choice);
                if (chosen) chosen = choice > 0 && choice < candies.Count;
            }

            return choice;


        }

        public decimal GetUserMoney()
        {
            decimal money = decimal.MinValue;
            bool success = false;
            while (money <= 0 && !success)
            {
                System.Console.Write("Please input the money allocated for candy: ");
                success = decimal.TryParse(Console.ReadLine(), out money);
            }
            return money;
        }
        

        
        public Change GiveChanges(decimal costProduct, decimal moneyGiven)
        {
            decimal change = moneyGiven - costProduct;

            int dollars = (int)(change / Money.Dollar);
            change -= dollars * Money.Dollar;

            int quarters = (int)(change / Money.Quarter);
            change -= quarters * Money.Quarter;

            int dimes = (int)(change / Money.Dime);
            change -= dimes * Money.Dime;

            int nickels = (int)(change / Money.Nickel);
            change -= nickels * Money.Nickel;

            int pennies = (int)(change / Money.Penny);

            return new Change( dollars, quarters, dimes, nickels, pennies );
        }

        


        public void BuyCandies(Candy candy, decimal money)
        {
            if(money < candy.Price)
            {
                throw new InsufficientExecutionStackException("Can not buy " + candy.Name + " with " + "$" + money);
            }
            if(candy.Quantity <= 0)
            {
                throw new ItemOutOfStockException(candy.Name + " is out of stock" ); 
            }
            _vendingMachineFileDao.RemoveCandy(candy.Name); 

        }

        
    }
} 
