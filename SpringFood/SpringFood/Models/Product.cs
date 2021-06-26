using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SpringFood.Models
{
    [Table("Products")]
    public class Product
    {
        [Column("Id")]
        public int Id { get; set; }
        [Required]
        [MaxLength(50)]
        public string Name { get; set; }
        [Required]
        public decimal Price { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        [MaxLength(500)]
        public string Image { get; set; }
        [Required]
        [MaxLength(50)]
        public string Category { get; set; }
        
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
