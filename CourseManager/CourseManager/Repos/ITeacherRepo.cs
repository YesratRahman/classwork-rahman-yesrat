using CourseManager.Models;
using System.Collections.Generic;

namespace CourseManager.Repos
{
    public interface ITeacherRepo
    {
        void Delete(int id);
        List<Teacher> GetAll();
        Teacher GetById(int id);
    }
}