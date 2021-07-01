using Microsoft.EntityFrameworkCore;
using SpringFood.Exceptions;
using SpringFood.Interfaces;
using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web.Http; 


namespace SpringFood.Repos
{
    public class ProductRepo: IProduct
    {
        private SpringFoodDbContext _context;

        public ProductRepo(SpringFoodDbContext context)
        {
            _context = context;
        }

        public int AddProduct(Product product)
        {
            _context.Products.Add(product);
            _context.SaveChanges();
            
            return product.Id; 
        }
        public List<Product> GetAllProducts()
        {
            return _context.Products.ToList();

        }

        public Product GetProductById(int id)
        {
            Product product = _context.Products.Find(id);
            if(product == null)
            {
                throw new ProductNotFoundException($"Couldn't find product with id {id}");
            }
           
            return product;
        }

        public Product GetProductByName(string name)
        {
            Product product = _context.Products.Where(p => p.Name == name).SingleOrDefault();
            if(product == null)
            {
                throw new ProductNotFoundException($"Couldn't find product with name {name}");
            }
            return product;
        }

        public void EditProduct(Product toEdit)
        {
            _context.Attach(toEdit);
            _context.Entry(toEdit).State = EntityState.Modified;
            _context.SaveChanges(); 

        }
        public void DeleteProduct(int id)
        {
            Product toDelete = new Product
            {
                Id = id
            };
            if(toDelete == null)
            {
                throw new ProductNotFoundException($"Couldn't find product with id {id}");
            }
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges();
        }

       
    }
}
