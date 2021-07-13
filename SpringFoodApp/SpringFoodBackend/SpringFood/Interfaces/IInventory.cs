
using SpringFoodBackend.Models.Domain;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFoodBackend.Interfaces
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
