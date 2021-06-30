using Microsoft.EntityFrameworkCore;
using SpringFood.Interfaces;
using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Repos
{
    public class InventoryRepo : IInventory
    {
        private SpringFoodDbContext _context; 
        public InventoryRepo(SpringFoodDbContext context)
        {
            _context = context; 
        }
        public int AddInventory(Inventory toAdd)
        {
            _context.Inventories.Add(toAdd);
            _context.SaveChanges();
            return toAdd.Id; 
        }

        public void DeleteInventory(int id)
        {
            Inventory toDelete = new Inventory
            {
                Id = id
            };
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges();
        }

        public void EditInventory(Inventory toEdit)
        {
            _context.Attach(toEdit);
            _context.Entry(toEdit).State = EntityState.Modified;
            _context.SaveChanges();
        }

        public List<Inventory> GetAllInventory()
        {
            return _context.Inventories.ToList(); 
        }

        public Inventory GetInventoryById(int id)
        {
            Inventory toGet = _context.Inventories.Find(id);
            return toGet; 
        }
    }
}
