using CourseManager.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace CourseManager.Repos
{
    public class DbCourseRepo : ICourseRepo
    {
        private string _conString = "Server=localhost;Database=CourseManager;Trusted_Connection=True;";

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public void Edit(Course toEdit)
        {
            throw new NotImplementedException();
        }

        public List<Course> GetAll()
        {
            List<Course> allCourses = new List<Course>();
            using (SqlConnection connection = new SqlConnection(_conString))
            {

                SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM courses", connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);

                for (int i = 0; i < resultData.Tables[0].Rows.Count; i++)
                {
                    Course toAdd = new Course();
                    toAdd.Id = resultData.Tables[0].Rows[i].Field<int>("Id");
                    toAdd.Name = resultData.Tables[0].Rows[i].Field<string>("Name");


                    allCourses.Add(toAdd);
                }

            }
            return allCourses;

        }

        public Course GetById(int id)
        {
            Course toReturn = null;
            using (SqlConnection connection = new SqlConnection(_conString))
            {
                SqlDataAdapter adapter = new SqlDataAdapter("SELECT Id, Name FROM courses WHERE Id =" + id, connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);
                if (resultData.Tables[0].Rows.Count == 1)
                {
                    toReturn = new Course();
                    toReturn.Id = int.Parse(resultData.Tables[0].Rows[0]["Id"].ToString());
                    toReturn.Name = resultData.Tables[0].Rows[0].Field<string>("Name");

                }
            }
            return toReturn;
        }
    }
}
