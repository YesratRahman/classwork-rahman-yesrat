using Microsoft.AspNetCore.Mvc;
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
    }
}
