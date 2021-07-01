using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SpringFood.Models
{
    public class OrderDetails
    {
        [Required]
        public int Quantity { get; set; }
        public Order Order { get; set; }
        public int? OrderId { get; set; }
        public Product Product { get; set; }
        public int? ProductId { get; set; }
       
    }
}
