using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Interfaces
{
    public interface IInventory
    {
        int AddInventory(Inventory toAdd);
        Inventory GetInventoryById(int id);
        List<Inventory> GetAllInventory();
        void EditInventory(Inventory toEdit);
        void DeleteInventory(int id);
    }
}
