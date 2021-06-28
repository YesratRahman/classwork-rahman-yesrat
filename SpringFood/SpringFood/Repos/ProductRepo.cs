using Microsoft.EntityFrameworkCore;
using SpringFood.Interfaces;
using SpringFood.Models;
using System.Collections.Generic;
using System.Linq;

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
            return product;
        }

        public Product GetProductByName(string name)
        {
            Product product = _context.Products.Where(p => p.Name == name).SingleOrDefault();
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
            _context.Attach(toDelete);
            _context.Remove(toDelete);
            _context.SaveChanges();
        }

       
    }
}
