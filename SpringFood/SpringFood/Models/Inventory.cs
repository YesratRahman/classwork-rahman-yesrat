using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SpringFood.Models
{
    
    public class Inventory
    {
        public int Id { get; set; }
        [Required]
        public int StockQty { get; set; }
        [Required]
        public int ReorderQty { get; set; }
        public Product Product { get; set; }
        //public Inventory() { }
        //public Inventory(Inventory that)
        //{
        //    this.Id = that.Id;
        //    this.StockQty = that.StockQty;
        //    this.ReorderQty = that.ReorderQty;
        //    Product = new Product(that.Product);
        //}
    }
}
