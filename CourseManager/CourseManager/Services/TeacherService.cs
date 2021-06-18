using System;
using System.Collections.Generic;
using CourseManager.Exceptions;
using CourseManager.Models;
using CourseManager.Repos;

namespace CourseManager.Services
{
    public class TeacherService
    {
        InMemTeacherRepo _teacherRepo = new InMemTeacherRepo();

        public List<Teacher> GetAll()
        {
            return _teacherRepo.GetAll(); 
        }

        public Teacher GetById(int id)
        {
            Teacher toReturn = _teacherRepo.GetById(id);

            if (toReturn == null)
            {
                throw new TeacherNotFoundException($"No teacher has an id of {id}.");
            }

            return toReturn;
        }
    }
}
