using SpringFood.Interfaces;
using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Repos
{
    public class OrderRepo: IOrder
    {
        private SpringFoodDbContext _context;

        public OrderRepo(SpringFoodDbContext context)
        {
            _context = context;
        }

        public int AddOrder(Order toAdd)
        {
            throw new NotImplementedException();
        }

        public void DeleteOrder(int id)
        {
            throw new NotImplementedException();
        }

        public void EditOrder(Order toEdit)
        {
            throw new NotImplementedException();
        }

        public List<Order> GetAllOrders()
        {
            throw new NotImplementedException();
        }

        public Order GetOrderById(int id)
        {
            throw new NotImplementedException();
        }
    }
}
