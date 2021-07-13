using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SpringFoodBackend.Models.Domain
{

    public class Inventory
    {
        public int Id { get; set; }
        [Required]
        public int StockQty { get; set; }
        [Required]
        public int ReorderQty { get; set; }
        [ForeignKey("Product")]
        public int ProductId { get; set; }
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
