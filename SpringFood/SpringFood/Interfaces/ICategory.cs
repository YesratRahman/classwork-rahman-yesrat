using SpringFood.Models;
using System.Collections.Generic;

namespace SpringFood.Repos
{
    public interface ICategory
    {
        int AddCategory(Category toAdd);
        List<Category> GetAllCategories(); 

    }
}