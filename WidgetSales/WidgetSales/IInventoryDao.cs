using System;
using System.Collections.Generic;

namespace WidgetSales
{
    public interface IInventoryDao
    {
        int Add(WidgetInventory toAdd);
        WidgetInventory GetByName(string name);
        WidgetInventory GetByWidgetId(int id);
        void RemoveWidgetByName(string name);
        IEnumerable<WidgetInventory> GetByCategory(string category);
        void EditWidget(WidgetInventory toEdit); 
    }
}
