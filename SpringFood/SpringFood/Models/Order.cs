using SpringFood.Interfaces;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Models
{
    [Table("Orders")]
    public class Order
    {
        public int Id { get; set;  }

    }
}
