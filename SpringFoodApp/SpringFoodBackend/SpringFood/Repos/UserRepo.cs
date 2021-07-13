using Microsoft.EntityFrameworkCore;
using SpringFoodBackend.Interfaces;
using SpringFoodBackend.Models.Auth;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFoodBackend.Repos
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

        public User GetUserById(int id)
        {
            User toGet = _context.Users.Find(id);
            return toGet; 
        }
        public Role GetRoleByName(string name)
        {
          Role role =  _context.Roles.SingleOrDefault(r => r.Name.ToLower() == name.ToLower());
            return role; 
        }

        public User GetUserByUserName(string username)
        {
            User toReturnUser = _context.Users.Include("Roles.SelectedRole").SingleOrDefault(u => u.Username.ToLower() == username.ToLower());
            return toReturnUser; 
        }
    }
}
