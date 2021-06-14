using System;
namespace VendingMachine.Models
{
    public interface ICandy
    {
        public int Id { set; get; }
        public string Name { get; }
        public int Quantity { get; set; }
        public decimal Price { get; }
    }
}
