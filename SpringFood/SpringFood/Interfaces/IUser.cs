using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Interfaces
{
    public interface IUser
    {
        int AddUser(User toAdd);
        User GetUsertById(int id);
        List<User> GetAllUsers();
        void EditUser(User toEdit);
        void DeleteUser(int id);
    }
}
