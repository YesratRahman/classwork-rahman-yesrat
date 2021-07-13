using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using SpringFoodBackend.Models.Domain;
using SpringFoodBackend.Repos;
using SpringFoodBackend.Services;

namespace SpringFoodBackend.Controllers
{
    [ApiController]
    [Authorize(Roles = "User")]
    [Route("/api/cart")]
    public class CartController:ControllerBase
    {
        SpringFoodService _service; 
        public CartController (SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context); 
        }

        [HttpPost]
        public IActionResult AddCart(Cart toAdd)
        {
            _service.AddCart(toAdd);
           return this.Accepted(toAdd); 
        }
        [HttpGet]
        public IActionResult GetAllCarts()
        {
            return this.Accepted(_service.GetAllCarts());
        }
        [HttpGet("{id}")]
        public IActionResult GetCartById(int id)
        {
            Cart cart = _service.GetCartById(id);
            return this.Accepted(cart);
        }
        [HttpPut]
        public IActionResult EditCart(Cart toEdit)
        {
            _service.EditCart(toEdit);
            return this.Accepted(toEdit);
        }
        [HttpDelete("{id}")]
        public IActionResult DeleteCart(int id)
        {
            _service.DeleteCart(id);
            return this.Accepted();
        }
    }
}
