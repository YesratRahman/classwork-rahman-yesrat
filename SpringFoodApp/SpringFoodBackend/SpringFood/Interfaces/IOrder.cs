using SpringFood.Models;
using System.Collections.Generic;

namespace SpringFood.Interfaces
{
    public interface IOrder
    {
        int AddOrder(Order toAdd);
        Order GetOrderById(int id);
        List<Order> GetAllOrders();
        void EditOrder(Order toEdit);
        void DeleteOrder(int id);
    }
}
