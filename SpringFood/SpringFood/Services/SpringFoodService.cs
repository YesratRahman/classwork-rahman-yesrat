using SpringFood.Models;
using SpringFood.Repos;
using System;
using System.Collections.Generic;

namespace SpringFood.Services
{
    public class SpringFoodService
    {
        ProductRepo _product; 
        public SpringFoodService(SpringFoodDbContext context)
        {
            _product = new ProductRepo(context); 
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
    }
}
