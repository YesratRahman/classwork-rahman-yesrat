using SpringFood.Models;
using System.Collections.Generic;

namespace SpringFood.Interfaces
{
    public interface ICart
    {
        int AddCart(Cart toAdd);
        Cart GetCartById(int id);
        List<Cart> GetAllCarts();
        void EditCart(Cart toEdit);
        void DeleteCart(int id);
    }
}
