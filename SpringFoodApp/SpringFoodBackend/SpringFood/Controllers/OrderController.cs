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
    [Route("/api/order")]
    public class OrderController: ControllerBase
    {
        SpringFoodService _service; 
        public OrderController(SpringFoodDbContext _context)
        {
            _service = new SpringFoodService(_context); 
        }

        [HttpPost]
        public IActionResult AddOrder(Order toAdd)
        {
            _service.AddOrder(toAdd);
            return Accepted(toAdd); 
        }
        [HttpGet]
        public IActionResult GetAllOrders()
        {
            return this.Accepted(_service.GetAllOrders());
        }
        [HttpGet("{id}")]
        public IActionResult GetOrderById(int id)
        {
            return Accepted(_service.GetOrderById(id));
        }
        [HttpPut]
        public IActionResult EditOrder(Order toEdit)
        {
            _service.EdtOrder(toEdit);
            return this.Accepted(toEdit);
        }
        [HttpDelete("{id}")]
        public IActionResult DeleteOrder(int id)
        {
            _service.DeleteOrder(id);
            return this.Accepted();
        }

    }
}
