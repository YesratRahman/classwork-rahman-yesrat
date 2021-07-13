using Microsoft.EntityFrameworkCore;
using SpringFoodBackend.Interfaces;
using SpringFoodBackend.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFoodBackend.Repos
{
    public class CartRepo : ICart
    {
        private SpringFoodDbContext _context;

        public CartRepo(SpringFoodDbContext context)
        {
            _context = context;
        }

        public int AddCart(Cart toAdd)
        {
            _context.Carts.Add(toAdd);
            _context.SaveChanges();
            return toAdd.Id; 
        }

        public List<Cart> GetAllCarts()
        {
            return _context.Carts.ToList(); 
        }

        public Cart GetCartById(int id)
        {
            Cart toGet = _context.Carts.Find(id);
            return toGet; 
        }
        public void DeleteCart(int id)
        {
            Cart toDelete = new Cart
            {
                Id = id
            };
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges(); 
        }

        public void EditCart(Cart toEdit)
        {
            _context.Attach(toEdit);
            _context.Entry(toEdit).State = EntityState.Modified;
            _context.SaveChanges();
        }
    }
}