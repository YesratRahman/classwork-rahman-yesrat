using System;
using System.Collections.Generic;
using VendingMachine.Daos;
using VendingMachine.Exceptions;
using VendingMachine.Models;

namespace VendingMachine.Services
{
    public class VendingMachineService : IVendingMachineService
    {
        private readonly IVendingMachineDao _vendingMachineFileDao;

        public VendingMachineService(IVendingMachineDao fileDao)
        {
            _vendingMachineFileDao = fileDao;
        }
        public List<Candy> GetAllCandies()
        {
            return _vendingMachineFileDao.GetAllCandies();
        }
        public int ShowCandies(List<Candy> candies)
        {

            int choice = -1;
            bool chosen = false;

            foreach (Candy candy in candies)
            {
                int choiceIndex = candies.IndexOf(candy) + 1;
                Console.WriteLine(choiceIndex + ": " + candy.Quantity + " " + candy.Name + " (" + "$" + candy.Price + " each)");
                Console.WriteLine();
            }

            while (!chosen) {
                if(choice < 1 || choice > candies.Count)
                {
                    Console.WriteLine("Enter a number between 1 to " + candies.Count + " to buy the candy: \n");

                    chosen = int.TryParse(Console.ReadLine(), out choice);
                }

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

            return new Change(dollars, quarters, dimes, nickels, pennies);
        }




        public void BuyCandies(Candy candy, decimal money)
        {
            if (money < candy.Price)
            {
                throw new InsufficientFundsException("Can not buy " + candy.Name + " with " + "$" + money);
            }
            if (candy.Quantity <= 0)
            {
                throw new ItemOutOfStockException(candy.Name + " is out of stock");
            }
            _vendingMachineFileDao.UpdateCandy(candy.Name);


            Change change = GiveChanges(candy.Price, money);

            Console.WriteLine(change.ToString());
        }
    }
} 
