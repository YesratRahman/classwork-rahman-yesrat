using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Models
{
    [Table("Brands")]
    public class Brand
    {
        public int Id { get; set; }
        [Required]
        [MaxLength(50)]
        public string Name { get; set; }

        public Brand()
        {

        }
        public Brand(string name)
        {
            this.Name = name;
        }


    }
}
