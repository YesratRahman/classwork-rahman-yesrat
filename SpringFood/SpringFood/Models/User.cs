using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Models
{
    [Table("Users")]
    public class User
    {
        public int Id { get; set; }
        [Required]
        [MaxLength(50)]
        public string Name { get; set; }
        [Required]
        [MaxLength(8)]
        public string Password { get; set; }
        [Required]
        [MaxLength(50)]
        public string Type { get; set; }
        //OneToMany 
        public List<Cart> Carts { get; set; } = new List<Cart>(); 
        public User()
        {

        }
        public User(User that)
        {
            this.Id = that.Id;
            this.Name = that.Name;
            this.Password = that.Password;
            this.Type = that.Type; 
        }
    }
}
