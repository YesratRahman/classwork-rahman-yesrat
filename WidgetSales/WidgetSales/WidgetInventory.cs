using System;
namespace WidgetSales
{
    public class WidgetInventory
    {
        public int Id { get; set; }
        public int StockCount { get; set; }
        public string Name { get; set; }
        public string Category { get; set; }


        public WidgetInventory()
        {
        }

        public WidgetInventory(WidgetInventory widget)
        {
            Id = widget.Id;
            StockCount = widget.StockCount;
            Name = widget.Name;
            Category = widget.Category; 
        }
    }
}
