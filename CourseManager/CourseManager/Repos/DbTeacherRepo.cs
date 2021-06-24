using CourseManager.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;

namespace CourseManager.Repos
{
    public class DbTeacherRepo : ITeacherRepo
    {
        private string _conString = "Server=localhost;Database=CourseManager;Trusted_Connection=True;"; 
        public void Delete(int id)
        {
            using (SqlConnection connection = new SqlConnection(_conString))
            {
                SqlDataAdapter adapter = new SqlDataAdapter($"UPDATE courses SET TeacherId = null WHERE TeacherId ={id}; DELETE FROM teachers WHERE Id = {id};", connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);

                
            }
        }

        public List<Teacher> GetAll()
        {
            List<Teacher> allTeachers = new List<Teacher>();
            using (SqlConnection connection = new SqlConnection(_conString))
            {

                SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM teachers", connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);

                for(int i = 0; i < resultData.Tables[0].Rows.Count; i++)
                {
                    Teacher toAdd = new Teacher();
                    //toAdd.Id = (int)resultData.Tables[0].Rows[i]["Id"];
                    toAdd.Id = resultData.Tables[0].Rows[i].Field<int>("Id");
                    toAdd.Name = resultData.Tables[0].Rows[i].Field<string>("Name");


                    allTeachers.Add(toAdd);
                }
                
            }
            return allTeachers; 
           
        }

        public Teacher GetById(int id)
        {
            Teacher toReturn = null;
            using (SqlConnection connection = new SqlConnection(_conString))
            {
                SqlDataAdapter adapter = new SqlDataAdapter("SELECT Id, Name FROM teachers WHERE Id =" + id, connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);
                if (resultData.Tables[0].Rows.Count == 1)
                {
                    toReturn = new Teacher();
                    toReturn.Id = int.Parse(resultData.Tables[0].Rows[0]["Id"].ToString());
                    toReturn.Name  = resultData.Tables[0].Rows[0].Field<string>("Name");

                    List<Course> toCourse = new List<Course>();
                    SqlDataAdapter courseAdapter = new SqlDataAdapter("SELECT Id, Name FROM courses WHERE TeacherId =" + id, connection);
                    DataSet resultCourseData = new DataSet();
                    courseAdapter.Fill(resultCourseData);
                    for (int i = 0; i < resultCourseData.Tables[0].Rows.Count; i++)
                    {
                        Course toAdd = new Course();
                        toAdd.Id = resultCourseData.Tables[0].Rows[i].Field<int>("Id");
                        toAdd.Name = resultCourseData.Tables[0].Rows[i].Field<string>("Name");
                        toCourse.Add(toAdd);
                    }
                    toReturn.Courses = toCourse; 

                }
            }
            return toReturn; 
        }
    }
}
