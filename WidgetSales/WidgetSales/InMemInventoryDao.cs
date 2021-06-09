using System;
using System.Linq;
using System.Collections.Generic;

namespace WidgetSales
{
    public class InMemInventoryDao : IInventoryDao
    {
        IEnumerable<WidgetInventory> _allInventories = new List<WidgetInventory>();

        public InMemInventoryDao()
        {
        }

        public int Add(WidgetInventory toAdd)
        {
            if(toAdd == null) throw new ArgumentNullException();
            if (toAdd.Name == null) throw new ArgumentNullException();
            if (toAdd.Category == null) throw new ArgumentNullException();
            if (toAdd.StockCount < 0) throw new ArgumentException(); 

            toAdd.Id = _allInventories.Count() + 1; 
            _allInventories = _allInventories.Concat(new WidgetInventory[] { new WidgetInventory(toAdd) });

            return toAdd.Id;
        }

        public WidgetInventory GetByName(string name)
        {
            return _allInventories.SingleOrDefault(w => w.Name == name);
        }

        public WidgetInventory GetByWidgetId( int id)
        {
            return _allInventories.SingleOrDefault(w => w.Id == id); 
        }

        public void RemoveWidgetByName(string name)
        {
            if (name == null) throw new ArgumentNullException(); 
            _allInventories = _allInventories.Where(w => w.Name != name).ToList(); 
        }

        public IEnumerable<WidgetInventory> GetByCategory(string category)
        {
            IEnumerable<WidgetInventory> toReturn = _allInventories.Where(w => w.Category == category);
            return toReturn; 
        }

        public void EditWidget(WidgetInventory toEdit)
        {
            _allInventories = _allInventories.Select(w => w.Id == toEdit.Id ? toEdit : w).ToList(); 
        }
    }
}
