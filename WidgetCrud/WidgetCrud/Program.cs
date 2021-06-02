using System;
using System.Collections.Generic;

namespace WidgetCrud
{
    class Program
    {
        static InMemWidgetDao dao = new InMemWidgetDao();


        static void Main(string[] args)
        {

            bool done = false;

            while (!done)
            {
                int choice = PrintMainMenu();
                int id;
                string category;
                Widget widget = new Widget { Id = 1, Name = "bicycle", Category = "transport", Price = 150m }; 
                switch (choice)
                {
                    case 1:
                        AddWidget();
                        break;
                    case 2:
                        Console.WriteLine("Enter the id for the widget to remove: ");
                        id = int.Parse(Console.ReadLine());
                        RemoveWidgetById(id);
                        break;
                    case 3:
                        EditWidget(widget);
                        break;
                    case 4:
                        Console.WriteLine("Enter the id to get the widget info: ");
                        id = int.Parse(Console.ReadLine());
                        GetWidgetById(id);
                        break;
                    case 5:
                        Console.WriteLine("Enter the category to get the widget info: ");
                        category = Console.ReadLine();
                        GetWidgetsByCat(category);
                        break;
                    case 6:
                        GetWidgetsByPage();
                        break;
                    case 7:
                        done = true;
                        break;

                }
            }
        }


        private static void GetWidgetsByCat(string category)
        {
            IEnumerable<Widget> allWidgets = dao.GetWidgetsByCategory(category);
            foreach (Widget widget in allWidgets)
            {
                Console.WriteLine("Name: " + widget.Name);
                Console.WriteLine("Category: " + widget.Category);
                Console.WriteLine("Price: " + widget.Price);
                Console.WriteLine();
            }
        }

        private static void GetWidgetById(int id)
        {
            Widget widget = dao.GetWidgetById(id);
            Console.WriteLine("Name: " + widget.Name + "\n");
            Console.WriteLine("Category: " + widget.Category + "\n");
            Console.WriteLine(" Price: " + widget.Price + "\n");
        }

        private static void RemoveWidgetById(int id)
        {
            dao.RemoveWidgetById(id);
            Console.WriteLine("Widget with id " + id + " is removed \n");

        }

        private static void AddWidget()
        {

            Widget widget = new Widget();
            int id = 0;
            id = dao.AddWidget(widget);
            Console.WriteLine("A Widget is created with id " + id);

            Widget anotherWidget = new Widget();
            widget.Id = 11;
            widget.Name = "Tablet";
            widget.Category = "Electronics";
            widget.Price = 1200;
            int newId = 0;
            newId = dao.AddWidget(anotherWidget);
            //Console.WriteLine("Another Widget is created with id " + newId);


        }

        private static void EditWidget(Widget updated)
        {

            Console.WriteLine("Enter the widget Id to update.");
            updated.Id = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter a name for the widget.");
            updated.Name = Console.ReadLine();

            Console.WriteLine("Enter a category for the widget.");
            updated.Category = Console.ReadLine();

            Console.WriteLine("Enter a price for the widget.");
            updated.Price = decimal.Parse(Console.ReadLine());

            
            dao.UpdateWidget(updated);
            Console.WriteLine("The widget with id " + updated.Id + " is updated");
        }

        private static void GetWidgetsByPage()
        {
            throw new NotImplementedException();
        }


        private static int PrintMainMenu()
        {

            Console.WriteLine("1:Add a Widget, 2: Remove a Widget by Id, 3: Edit a Widget, " +
                "4: Get Widgets by Id, 5: Get Widgets by Category, 6: Get Widgets by Page ");
            string readlLine = Console.ReadLine();
            int choice = int.Parse(readlLine);
            return choice;
        }
    }
}
