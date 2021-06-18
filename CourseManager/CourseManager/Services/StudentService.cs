using System;
using CourseManager.Exceptions;
using CourseManager.Models;
using CourseManager.Repos;

namespace CourseManager.Services
{
    public class StudentService
    {
        InMemStudentRepo _studentRepo = new InMemStudentRepo();


        public object GetAll()
        {
            return _studentRepo.GetAll();
        }

        public Student GetById(int id)
        {
            Student toReturn = _studentRepo.GetById(id);

            if (toReturn == null)
            {
                throw new StudentNotFoundException($"No student has an id of {id}.");
            }

            return toReturn;
        }
    }
}
