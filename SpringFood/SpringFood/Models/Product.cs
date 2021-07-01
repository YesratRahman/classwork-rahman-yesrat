﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Newtonsoft.Json;

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
        [Column(TypeName = "decimal(5,3")]
        public decimal Price { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        public string Image { get; set; }
        [Required]
        [MaxLength(200)]
        public string Description { get; set; }
        public List<OrderDetails> OrderDetails { get; set; }
        public int CategoryId { get; set; }

        public Category Category{ get; set; }


        //public Product()
        //{
        //}

        //public Product(Product that)
        //{
        //    this.Id = that.Id;
        //    this.Name = that.Name;
        //    this.Quantity = that.Quantity;
        //    this.Image = that.Image;
        //    Category = new Category(that.Category); 
        //}

    }
}
