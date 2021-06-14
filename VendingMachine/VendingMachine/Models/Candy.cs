using System;
namespace VendingMachine.Models
{
    public class Candy: ICandy
    {
        public int Id { set; get; }
        public string Name { get; }
        public int Quantity { get; set; }
        public decimal Price { get; }

        public Candy()
        {
        }

        public Candy(string name, int quantity, decimal price)
        {
            Name = name;
            Quantity = quantity;
            Price = price;
        }

        public Candy(ICandy that)
        {
            Id = that.Id;
            Name = that.Name;
            Quantity = that.Quantity;
            Price = that.Price;
            
        }
    }
}
