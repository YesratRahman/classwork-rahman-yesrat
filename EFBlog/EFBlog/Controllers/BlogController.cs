using EFBlog.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EFBlog.Controllers
{
    [ApiController]
    public class BlogController : Controller
    {
        BlogDbContext _context; 
        public BlogController(BlogDbContext context)
        {
            //should instantiate new service object
            //this is not the final form 
            _context = context; 
        }
        [HttpPost("/AddUser")]
        public IActionResult AddUser(BlogUser user)
        {
            _context.BlogUsers.Add(user);
            _context.SaveChanges();
            return this.Accepted(user.BlogUserId); 
        }

        [HttpGet("/User")]
        public IActionResult GetAllUsers()
        {
            return Accepted(_context.BlogUsers.ToList());
        }

        [HttpGet("User/{id}")]
        public IActionResult Getuser(int id)
        {
           BlogUser user =  _context.BlogUsers.Find(id);
            return this.Accepted(user);
        }
        [HttpPut("/User")]
        public IActionResult EditUser(BlogUser edited)
        {
            //BlogUser curUser = _context.BlogUsers.Find(edited.BlogUserId);
            //_context.Entry(curUser).CurrentValues.SetValues(edited);
            _context.Attach(edited);
            _context.Entry(edited).State = EntityState.Modified;
            _context.SaveChanges();
            return Accepted(); 
        }

        [HttpDelete("/User/{id}")]
        public IActionResult DeleteUser(int id)
        {
            //BlogUser toDelete = _context.BlogUsers.Find(id);
            BlogUser toDelete = new BlogUser
            {
                BlogUserId = id
            };
            _context.Attach(toDelete); 
            _context.Remove(toDelete);
            _context.SaveChanges();
            return Accepted(); 

        }
    }
}
