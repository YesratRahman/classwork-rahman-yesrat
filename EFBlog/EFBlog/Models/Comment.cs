using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace EFBlog.Models
{
    public class Comment
    {
        [Column("id")]
        public int CommentId { get; set;  }
        [Required]
        public BlogUser Author { get; set; }
        [Required]
        [MaxLength(200)]
        public string Text { get; set;  }
        [Required]
        public BlogPost ParentPost { get; set;  }
    }
}
