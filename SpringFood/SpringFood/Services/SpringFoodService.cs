using SpringFood.Models;
using SpringFood.Repos;
using System;
using System.Collections.Generic;

namespace SpringFood.Services
{
    public class SpringFoodService
    {
        ProductRepo _product;
        UserRepo _user;
        CategoryRepo _category; 
        public SpringFoodService(SpringFoodDbContext context)
        {
            _product = new ProductRepo(context);
            _user = new UserRepo(context);
            _category = new CategoryRepo(context); 
        }
        public int AddProduct(Product product)
        {
            return _product.AddProduct(product); 
        }

        public Product GetProductById(int id)
        {
            return _product.GetProductById(id);
        }

        public Product GetProductByName(string name)
        {
            return _product.GetProductByName(name);
        }

        public List<Product> GetAllProducts()
        {
            return _product.GetAllProducts();
        }



        public void DeleteProduct(int id)
        {
             _product.DeleteProduct(id); 
        }

        public void EditProduct(Product product)
        {
            _product.EditProduct(product); 
        }
        public int AddUser(User toAdd)
        {
            return _user.AddUser(toAdd); 
        }

        public List<User> GetAllUsers()
        {
            return _user.GetAllUsers(); 
        }
        public void EdtUser(User toEdit)
        {
            _user.EditUser(toEdit); 
        }
        public User GetUserById(int id)
        {
             return _user.GetUsertById(id); 
        }
        public void DeleteUser(int id)
        {
            _user.DeleteUser(id);
        }

        public int AddCategory(Category toAdd)
        {
           return _category.AddCategory(toAdd);
        }

        public List<Category> GetAllCategories()
        {
            return _category.GetAllCategories();
        }
        
    }
}
