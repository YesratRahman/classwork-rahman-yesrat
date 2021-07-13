
using SpringFoodBackend.Interfaces;
using SpringFoodBackend.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFoodBackend.Repos
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
            _context.Orders.Add(toAdd);
            _context.SaveChanges(); 
            foreach(OrderDetails details in toAdd.OrderDetails)
            {
                details.OrderId = toAdd.Id;
                _context.OrderDetails.Add(details); 
            }
            return toAdd.Id; 
        }

     

        public List<Order> GetAllOrders()
        {
            List<Order> toReturn = _context.Orders.ToList();
            foreach (Order order in toReturn)
            {
                order.OrderDetails = _context.OrderDetails.Where(oDetails => oDetails.OrderId == order.Id).ToList();
            }

            return toReturn;
        }

        public Order GetOrderById(int id)
        {
            Order toGet = _context.Orders.Find(id);
            toGet.OrderDetails = _context.OrderDetails.Where(oDetails => oDetails.OrderId == id).ToList();
            return toGet;
        }
        public void DeleteOrder(int id)
        {
            Order toDelete = _context.Orders.Find(id);
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges();
        }

        public void EditOrder(Order toEdit)
        {
            throw new NotImplementedException();
        }

        public object GetOrdersByUserId(int curUserId)
        {
            return _context.Orders.Where(o => o.Purchaser.Id == curUserId).ToList(); 
        }
    }
}
