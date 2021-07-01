using Microsoft.EntityFrameworkCore;
using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood
{
    public class SpringFoodDbContext: DbContext
    {
        public DbSet<Product> Products { get; set; }
        public DbSet<User> Users { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<Inventory> Inventories { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Cart> Carts { get; set; }
        public DbSet<OrderDetails> OrderDetails { get; set; }
        public SpringFoodDbContext(DbContextOptions<SpringFoodDbContext> options) : base(options)
        {

        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<OrderDetails>().HasKey(orderDetails => new { orderDetails.OrderId, orderDetails.ProductId });
            //modelBuilder.Entity<Category>().HasMany(p => p.Products).WithOne(c => c.Category);
            //modelBuilder.Entity<Product>().HasKey(c => new { c.Id, c.CategoryId });
        }

    }
}
