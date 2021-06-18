using System;
using CourseManager.Exceptions;
using CourseManager.Models;
using CourseManager.Services;
using Microsoft.AspNetCore.Mvc;

namespace CourseManager.Controllers
{
    public class TeacherController : Controller 
    {
        TeacherService _service = new TeacherService();

        //Get all teachers

        public IActionResult Index()
        {
           var teacher = _service.GetAll();
            return View(teacher); 
        }

        //Get details of a teacher
        public IActionResult Details(int? id)
        {
            if (id != null)
            {
                try
                {
                    Teacher toDisplay = _service.GetById(id.Value);
                    return View(toDisplay);

                }
                catch (TeacherNotFoundException ex)
                {
                    return NotFound(ex.Message);
                }
            }
            return BadRequest();
        }

    }
}
