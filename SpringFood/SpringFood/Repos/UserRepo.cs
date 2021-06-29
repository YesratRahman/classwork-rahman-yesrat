using Microsoft.EntityFrameworkCore;
using SpringFood.Interfaces;
using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Repos
{
    public class UserRepo : IUser
    {
        private SpringFoodDbContext _context;
        public UserRepo(SpringFoodDbContext context)
        {
            _context = context;
        }

        
        public int AddUser(User toAdd)
        {
            _context.Users.Add(toAdd);
            _context.SaveChanges();
            return toAdd.Id; 
        }

        public void DeleteUser(int id)
        {
            User toDelete = new User
            {
                Id = id
        };
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges(); 
        }

        public void EditUser(User toEdit)
        {
            _context.Attach(toEdit);
            _context.Entry(toEdit).State = EntityState.Modified;
            _context.SaveChanges(); 
        }

        public List<User> GetAllUsers()
        {
            return _context.Users.ToList(); 
        }

        public User GetUsertById(int id)
        {
            User toGet = _context.Users.Find(id);
            return toGet; 
        }
    }
}
