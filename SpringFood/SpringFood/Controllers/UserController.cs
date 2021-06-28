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
    public class UserController : ControllerBase
    {
        SpringFoodService _service;
        public UserController(SpringFoodDbContext context)
        {
            _service = new SpringFoodService(context);
        }
        [HttpPost("addUser")]
        public IActionResult AddUser(User toAdd)
        {
            _service.AddUser(toAdd);
            return this.Accepted(toAdd);

        }
        [HttpGet("users")]
        public IActionResult GetAllUsers()
        {
            return this.Accepted(_service.GetAllUsers());
        }
        [HttpDelete("user/{id}")]
        public IActionResult DeleteUser(int id)
        {
            _service.DeleteUser(id);
            return this.Accepted();
        }

    }
} 
