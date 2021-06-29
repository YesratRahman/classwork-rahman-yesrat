using Microsoft.AspNetCore.Mvc;
using SpringFood.Models;
using SpringFood.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpringFood.Controllers
{
    [ApiController]
    [Route("/api")]
    public class CategoryController: ControllerBase 
    {
        SpringFoodService _service;
        public CategoryController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context);
        }
        [HttpPost("addCategory")]
        public IActionResult AddCategory(Category toAdd)
        {
            _service.AddCategory(toAdd);
            return this.Accepted(toAdd);

        }
        [HttpGet("categories")]
        public IActionResult GetAllCategories()
        {

            return this.Accepted(_service.GetAllCategories());
        }
    }
}
