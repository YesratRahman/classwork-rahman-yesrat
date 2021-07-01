using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SpringFood.Models
{
    [Table("CartProducts")]
    public class CartProduct
    {
        public int Id { get; set; }
        [Required]
        public int Quantity { get; set; }
        //Many to One 
        public Cart Cart; 
        //Many to one 
        public Product Product { get; set; }


    }
}
