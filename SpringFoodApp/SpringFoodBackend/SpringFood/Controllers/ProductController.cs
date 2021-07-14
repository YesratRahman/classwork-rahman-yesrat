using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using SpringFoodBackend.Models.Domain;
using SpringFoodBackend.Repos;
using SpringFoodBackend.Services;
using System.Linq;
using System.Security.Claims;

namespace SpringFoodBackend.Controllers
{

    [ApiController]
    [Route("/api/product")]
    public class ProductController : ControllerBase
    {

        SpringFoodService _service;
        public ProductController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context);
        }
        [HttpPost]
        [Authorize]
        public IActionResult AddProduct(Product product)
        {
            if (this.User.Claims.Any(c => c.Type == ClaimTypes.Role.ToString() && c.Value == "Admin"))
            {
                _service.AddProduct(product);
                return this.Accepted(product);
            }
            else
            {
                return this.Unauthorized("Only admin can addd product!");
            }

        }

        [HttpGet("{id}")]
        public IActionResult GetProductById(int id)
        {
            Product product = _service.GetProductById(id);
            return this.Accepted(product);

        }
        [HttpGet("name/{name}")]
        public IActionResult GetProductByName(string name)
        {
            Product product = _service.GetProductByName(name);
            return this.Accepted(product);

        }
        [HttpGet]
        public IActionResult GetAllProducts()
        {

            return this.Accepted(_service.GetAllProducts());
        }

        [HttpPut("{id}")]

        public IActionResult EditProduct(Product product)
        {
            _service.EditProduct(product);
            return this.Accepted(product);
        }

        [HttpDelete("{id}")]
        public IActionResult DeleteProduct(int id)
        {

            if (this.User.Claims.Any(c => c.Type == ClaimTypes.Role.ToString() && c.Value == "Admin"))
            {
                _service.DeleteProduct(id);
                return this.Accepted();
            }
            else
            {
                return this.Unauthorized("Only admin can delete a product!");
            }
           
        }


    }
} 
