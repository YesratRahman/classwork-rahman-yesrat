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
        InventoryRepo _inventory;
        CartRepo _cart;
        OrderRepo _order; 
        public SpringFoodService(SpringFoodDbContext context)
        {
            _product = new ProductRepo(context);
            _user = new UserRepo(context);
            _category = new CategoryRepo(context);
            _inventory = new InventoryRepo(context);
            _cart = new CartRepo(context);
            _order = new OrderRepo(context); 

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
            return _user.GetUserById(id);
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

        public int AddInventory(Inventory toAdd)
        {
            return _inventory.AddInventory(toAdd);
        }
        public Inventory GetInventoryById(int id)
        {
            return _inventory.GetInventoryById(id);
        }
        public List<Inventory> GetAllInventory()
        {
            return _inventory.GetAllInventory();
        }
        public void EditInventory(Inventory toEdit)
        {
            _inventory.EditInventory(toEdit);
        }
        public void DeleteInventory(int id)
        {
            _inventory.DeleteInventory(id);
        }

        public int AddCart(Cart toAdd)
        {
            return _cart.AddCart(toAdd); 
        }
        public Cart GetCartById(int id)
        {
           return _cart.GetCartById(id); 
        }
        public List<Cart> GetAllCarts()
        {
           return _cart.GetAllCarts(); 
        }
        public void EditCart(Cart toEdit)
        {
            _cart.EditCart(toEdit); 
        }
        public void DeleteCart(int id)
        {
            _cart.DeleteCart(id);
        }

    }
} 
