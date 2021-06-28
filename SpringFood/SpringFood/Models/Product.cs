using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SpringFood.Models
{
    [Table("Products")]
    public class Product
    {
        public int Id { get; set; }
        [Required]
        [MaxLength(50)]
        public string Name { get; set; }
        [Required]
        public decimal Price { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        public string Image { get; set; }
        [Required]
        [MaxLength(200)]
        public string Description { get; set; }

        public Category Category{ get; set; }
        public Brand Brand { get; set; }
        
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
