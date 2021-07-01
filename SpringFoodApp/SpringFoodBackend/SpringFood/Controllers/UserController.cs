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
    [Route("/api/user")]
    public class UserController : ControllerBase
    {
        SpringFoodService _service;
        public UserController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context);
        }
        [HttpPost]
        public IActionResult AddUser(User toAdd)
        {
            _service.AddUser(toAdd);
            return this.Accepted(toAdd);

        }
        [HttpGet]
        public IActionResult GetAllUsers()
        {
            return this.Accepted(_service.GetAllUsers());
        }
        [HttpPut]
        public IActionResult EditUser(User toEdit)
        {
            _service.EdtUser(toEdit);
            return this.Accepted(toEdit);
        }
        [HttpDelete("{id}")]
        public IActionResult DeleteUser(int id)
        {
            _service.DeleteUser(id);
            return this.Accepted();
        }
        

    }
} 
