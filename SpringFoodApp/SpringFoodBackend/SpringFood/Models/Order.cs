using SpringFood.Interfaces;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SpringFood.Models
{
    [Table("Orders")]
    public class Order
    {
        public int Id { get; set;  }
        [Required]
        public DateTime Date { get; set; }
        [Required]
        public string Address { get; set; }
        [Required]
        [Column(TypeName = "decimal(5,3")]
        public decimal OrderTotal { get; set; }
        public List<OrderDetails> OrderDetails { get; set; }

    }
}
