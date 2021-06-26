using Microsoft.AspNetCore.Mvc;
using SpringFood.Models;
using SpringFood.Services;

namespace SpringFood.Controllers
{

    [ApiController]
    public class ProductController: ControllerBase 
    {

        SpringFoodService _service; 
        public ProductController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context); 
        }
        [HttpPost("/addProduct")]
        public IActionResult AddProduct(Product product)
        {
            _service.AddProduct(product);
            return this.Accepted(product); 

        }

        [HttpGet("/product/{id}")]
        public IActionResult GetProductById(int id)
        {
            _service.GetProductById(id);
            return this.Accepted(); 

        }
        [HttpGet("/product/{name}")]
        public IActionResult GetProductByName(string name)
        {
            _service.GetProductByName(name);
            return this.Accepted();

        }

        [HttpGet("/products")]
        public IActionResult GetAllProducts()
        {
            _service.GetAllProducts();
            return this.Accepted(); 
        }

        [HttpPut("/product")]

        public IActionResult EditProduct(Product product)
        {
            _service.EditProduct(product);
           return this.Accepted(); 
        }

        [HttpDelete("/product/{id}")]
        public IActionResult DeleteProduct(int id)
        {
            _service.DeleteProduct(id);
           return this.Accepted(); 
        }
    }
}
