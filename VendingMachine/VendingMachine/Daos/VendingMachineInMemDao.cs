using System;
using System.Collections.Generic;
using System.Linq;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
    public class VendingMachineInMemDao : IVendingMachineDao
    {
        private List<Candy> _candies = new List<Candy>(); 
     
        public VendingMachineInMemDao()
        {
            _candies.Add(new Candy("Necco Wafers Candy", 4, 2.00m));
            _candies.Add(new Candy("Nerds Candy", 11, 1.50m));
            _candies.Add(new Candy("Milky Way Candy Bar", 18, 1.25m));
            _candies.Add(new Candy("Hershey's Kisses", 10, 2.00m));
           
        }
        public List<Candy> GetAllCandies()
        {
            return _candies.Select(candy => new Candy(candy)).ToList();
        }

        public Candy GetCandyById(int id)
        {
            var candy = _candies.SingleOrDefault(w => w.Id == id);

            if (candy == null) throw new ArgumentException("Not found with this id");

            return candy;
        }

        public void UpdateCandy(string name)
        {
            _candies = GetAllCandies()
                .Select(candy => candy.Name == name ?
                new Candy(candy.Name, candy.Quantity - 1, candy.Price) : candy)
                .ToList();
        }
    }
}
