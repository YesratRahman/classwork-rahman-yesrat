using System;
using CourseManager.Exceptions;
using CourseManager.Models;
using CourseManager.Services;
using Microsoft.AspNetCore.Mvc;

namespace CourseManager.Controllers 
{
    public class StudentController : Controller
    {
        StudentService _service = new StudentService();

        [HttpGet]
        public IActionResult Index()
        {
            var student = _service.GetAll();
            return View(student);
        }

        public IActionResult Details(int? id)
        {
            if (id != null)
            {
                try
                {
                    Student toDisplay = _service.GetById(id.Value);
                    return View(toDisplay);

                }
                catch (StudentNotFoundException ex)
                {
                    return NotFound(ex.Message);
                }
            }
            return BadRequest();
        }
    }
}
