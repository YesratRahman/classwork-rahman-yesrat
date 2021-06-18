using System;
namespace SpringFood.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Quantity { get; set; }
        public string Image { get; set; }
        public ProductCategory Category { get; set; }
        
        public Product()
        {
        }

        public Product(Product that)
        {
            this.Id = that.Id;
            this.Name = that.Name;
            this.Quantity = that.Quantity;
            this.Image = that.Image;
            this.Category = that.Category; 
        }

    }
}
