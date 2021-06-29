﻿using Microsoft.EntityFrameworkCore;
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
        public SpringFoodDbContext(DbContextOptions<SpringFoodDbContext> options) : base(options)
        {

        }

    }
}
