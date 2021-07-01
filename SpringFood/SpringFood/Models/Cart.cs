using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace SpringFood.Models
{
    [Table("Carts")]
    public class Cart
    {
        public int Id { get; set; }
        [Required]
        public DateTime PurchaseDate { get; set; }
        [Required]
        public string Status { get; set; }
        //ManyToOne 
        public User User { get; set; }
        //OneToMany
        public List<CartProduct> CartProducts { get; set; } = new List<CartProduct>(); 

    }
}
