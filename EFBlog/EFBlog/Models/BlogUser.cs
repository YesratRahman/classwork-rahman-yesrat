using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace EFBlog.Models
{
    [Table("Users")]
    public class BlogUser
    {
        [Column("id")]
        public int BlogUserId { get; set; }

        [Required]
        [MaxLength(50)]
        public string BlogUserName { get; set;  }
    }
}
