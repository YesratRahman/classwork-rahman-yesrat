using System;
using System.Collections.Generic;
using System.Linq;

namespace WidgetCrud
{
    public class InMemWidgetDao
    {
        List<Widget> _allWidgets = new List<Widget>
        {
                new Widget { Id = 1, Name = "bicycle", Category = "transport", Price = 150m },
                new Widget { Id = 2, Name = "concrete", Category = "building supplies", Price = 25m },
                new Widget { Id = 3, Name = "bread", Category = "food", Price = 3m },
                new Widget { Id = 4, Name = "train", Category = "transport", Price = 15000000m },
                new Widget { Id = 5, Name = "eggs", Category = "food", Price = 1.5m },
                new Widget { Id = 6, Name = "lumber", Category = "building supplies", Price = 50m },
                new Widget { Id = 7, Name = "car", Category = "transport", Price = 15000m },
                new Widget { Id = 8, Name = "milk", Category = "food", Price = 4m },

        };

        public InMemWidgetDao()
        {
        }


        public int AddWidget(Widget toAdd)
        {

            int id = 0;
            foreach (Widget widget in _allWidgets)
            {
                if (widget.Id > id)
                {
                    id = widget.Id;
                }
            }
            id++;
            Console.WriteLine("Enter the name of a widget: ");
            toAdd.Name = Console.ReadLine();

            Console.WriteLine("Enter the category of the widget: ");
            toAdd.Category = Console.ReadLine();

            Console.WriteLine("Enter the price of the widget: ");
            toAdd.Price = decimal.Parse(Console.ReadLine());

            _allWidgets.Add(toAdd);
            return id;
        }

        public Widget GetWidgetById(int id)
        {
            Widget widget = null;

            widget = _allWidgets.Where(val => val.Id == id).SingleOrDefault();
            return widget;


        }

        public void RemoveWidgetById(int id)
        {
            Widget widget = new Widget();
            var todelete = _allWidgets.Where(d => d.Id == id).Single();
            _allWidgets.Remove(todelete);

        }

        public void UpdateWidget(Widget updated)
        {
            Widget widgetUpdate = _allWidgets.Where(n => n.Id == updated.Id).Single();
            widgetUpdate = updated;
        }



        public IEnumerable<Widget> GetWidgetsByCategory(string category)
        {
            var toReturn = _allWidgets.Where(x => x.Category == category);
            return toReturn;
        }

        public IEnumerable<Widget> GetAllWidgetsForPage(int pageSize, int pageNumber)
        {
            //assuming each page is pageSize wide, return the pageNumberth page of widgets
            //order by name?

            throw new NotImplementedException();
        }
    }
}
