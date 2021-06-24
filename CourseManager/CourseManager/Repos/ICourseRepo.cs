using CourseManager.Models;
using System.Collections.Generic;

namespace CourseManager.Repos
{
    public interface ICourseRepo
    {
        void Delete(int id);
        List<Course> GetAll();
        Course GetById(int id);
        void Edit(Course toEdit); 

    }
}