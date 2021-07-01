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
    [Route("/api/inventory")]
    public class InventoryController: ControllerBase
    {
        SpringFoodService _service; 
        public InventoryController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context); 
        }
        [HttpPost]
        public IActionResult AddInventory(Inventory toAdd)
        {
            _service.AddInventory(toAdd);
            return this.Accepted(toAdd); 
        }
        [HttpGet]
        public IActionResult GetAllInventories()
        {
            return this.Accepted(_service.GetAllInventory()); 
        }
        [HttpGet("{id}")]
        public IActionResult GetInventoryById(int id)
        {
            Inventory inventory = _service.GetInventoryById(id); 
            return this.Accepted(inventory); 
        }
        [HttpPut]
        public IActionResult EditInventory(Inventory toEdit)
        {
            _service.EditInventory(toEdit);
            return this.Accepted(toEdit); 
        }
        [HttpDelete("{id}")]
        public IActionResult DeleteInventory(int id)
        {
            _service.DeleteInventory(id);
            return this.Accepted();
        }
    }
}
