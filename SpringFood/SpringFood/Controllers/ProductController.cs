using Microsoft.AspNetCore.Mvc;
using SpringFood.Models;
using SpringFood.Services;

namespace SpringFood.Controllers
{

    [ApiController]
    [Route("/api/product")]
    public class ProductController: ControllerBase 
    {

        SpringFoodService _service; 
        public ProductController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context); 
        }
        [HttpPost]
        public IActionResult AddProduct(Product product)
        {
            _service.AddProduct(product);
            return this.Accepted(product); 

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
           
            return this.Accepted( _service.GetAllProducts()); 
        }

        [HttpPut]

        public IActionResult EditProduct(Product product)
        {
            _service.EditProduct(product);
           return this.Accepted(product); 
        }

        [HttpDelete("{id}")] 
        public IActionResult DeleteProduct(int id)
        {
            _service.DeleteProduct(id);
           return this.Accepted(); 
        }

        
    }
}
