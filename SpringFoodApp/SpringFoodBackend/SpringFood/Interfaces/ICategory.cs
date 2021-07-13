
using SpringFoodBackend.Models.Domain;
using System.Collections.Generic;

namespace SpringFoodBackend.Interfaces
{
    public interface ICategory
    {
        int AddCategory(Category toAdd);
        List<Category> GetAllCategories(); 

    }
}