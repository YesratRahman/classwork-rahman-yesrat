using System;
using System.Collections.Generic;
using System.Linq;
using VendingMachine.Models;

namespace VendingMachine.Daos
{
    public class VendingMachineInMemDao
    {
        private List<Candy> _candies = new List<Candy>(); 
        public VendingMachineInMemDao()
        {
            _candies.Add(new Candy("Necco Wafers Candy", 20, 2.00m));
            _candies.Add(new Candy("Nerds Candy", 15, 1.50m));
            _candies.Add(new Candy("Milky Way Candy Bar", 18, 1.25m));
            _candies.Add(new Candy("Hershey's Kisses", 10, 2.00m));
            _candies.Add(new Candy("Laffy Taffy", 12, 1.50m));
            _candies.Add(new Candy("Dubble Bubble Gum", 10, 3.00m)); 
        }

        public List<Candy> GetCandies()
        {
            return _candies.Select(candy => new Candy(candy)).ToList();
        }

        public Candy GetCandyById(int id)
        {
            var candy = _candies.SingleOrDefault(w => w.Id == id);

            if (candy == null) throw new ArgumentException("Not found with this id");

            return candy;
        }
    }
}
