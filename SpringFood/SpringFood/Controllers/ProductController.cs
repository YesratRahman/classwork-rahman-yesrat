using Microsoft.AspNetCore.Mvc;
using SpringFood.Models;
using SpringFood.Services;

namespace SpringFood.Controllers
{

    [ApiController]
    [Route("/api")]
    public class ProductController: ControllerBase 
    {

        SpringFoodService _service; 
        public ProductController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context); 
        }
        [HttpPost("addProduct")]
        public IActionResult AddProduct(Product product)
        {
            _service.AddProduct(product);
            return this.Accepted(product); 

        }

        [HttpGet("product/{id}")]
        public IActionResult GetProductById(int id)
        {
            Product product = _service.GetProductById(id);
            return this.Accepted(product); 

        }
        [HttpGet("product/name/{name}")]
        public IActionResult GetProductByName(string name)
        {
            Product product = _service.GetProductByName(name); 
            return this.Accepted(product);

        }

        [HttpGet("products")]
        public IActionResult GetAllProducts()
        {
           
            return this.Accepted( _service.GetAllProducts()); 
        }

        [HttpPut("product")]

        public IActionResult EditProduct(Product product)
        {
            _service.EditProduct(product);
           return this.Accepted(product); 
        }

        [HttpDelete("product/{id}")]
        public IActionResult DeleteProduct(int id)
        {
            _service.DeleteProduct(id);
           return this.Accepted(); 
        }

        
    }
}
