using SpringFood.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Repos
{
    public class CategoryRepo : ICategory
    {
        private SpringFoodDbContext _context;

        public CategoryRepo(SpringFoodDbContext context)
        {
            _context = context;
        }
        public int AddCategory(Category toAdd)
        {
            _context.Categories.Add(toAdd);
            _context.SaveChanges();
            return toAdd.Id;
        }

        public List<Category> GetAllCategories()
        {
            return _context.Categories.ToList(); 
        }
    }
}
