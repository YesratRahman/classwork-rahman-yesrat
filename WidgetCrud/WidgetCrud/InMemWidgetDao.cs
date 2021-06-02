using System;
using System.Collections.Generic;
using System.Linq;

namespace WidgetCrud
{
    public class InMemWidgetDao
    {
        IEnumerable<Widget> _allWidgets = new List<Widget>(); 
        
        public InMemWidgetDao()
        {
        }


        public int AddWidget(Widget toAdd)
        {

            //int id = 0;

            //foreach (Widget widget in _allWidgets)
            //{
            //    if (widget.Id > id)
            //    {
            //        id = widget.Id;
            //    }
            //}
            //id++;
            //Console.WriteLine("Enter the name of a widget: ");
            //toAdd.Name = Console.ReadLine();

            //Console.WriteLine("Enter the category of the widget: ");
            //toAdd.Category = Console.ReadLine();

            //Console.WriteLine("Enter the price of the widget: ");
            //toAdd.Price = decimal.Parse(Console.ReadLine());

            //_allWidgets.Add(toAdd);
            //return id;

            toAdd.Id = _allWidgets.Max(w => w.Id) + 1;
            _allWidgets = _allWidgets.Concat(new Widget[] { new Widget(toAdd) }); 
            return toAdd.Id; 
        }

        public Widget GetWidgetById(int id)
        {
            return _allWidgets.SingleOrDefault(w => w.Id == id); 


        }

        public void RemoveWidgetById(int id)
        {
            _allWidgets =  _allWidgets.Where(w => w.Id != id); 

        }

        public void UpdateWidget(Widget updated)
        {
            _allWidgets = _allWidgets.Select(w => w.Id == updated.Id ? new Widget(updated) : w); 
        }



        public IEnumerable<Widget> GetWidgetsByCategory(string category)
        {
            return _allWidgets.Where(x => x.Category == category);
            
        }

        public IEnumerable<Widget> GetAllWidgetsForPage(int pageSize, int pageNumber)
        {
            //assuming each page is pageSize wide, return the pageNumberth page of widgets
            //order by name?

            return _allWidgets.OrderBy(w => w.Id)
                .Skip((pageNumber - 1) * pageSize)
                .Take(pageSize);
            
        }
    }
}
