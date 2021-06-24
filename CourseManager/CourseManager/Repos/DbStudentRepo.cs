using CourseManager.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace CourseManager.Repos
{
    public class DbStudentRepo : IStudentRepo
    {
        private string _conString = "Server=localhost;Database=CourseManager;Trusted_Connection=True;";

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public List<Student> GetAll()
        {
            List<Student> allTeachers = new List<Student>();
            using (SqlConnection connection = new SqlConnection(_conString))
            {

                SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM students", connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);

                for (int i = 0; i < resultData.Tables[0].Rows.Count; i++)
                {
                    Student toAdd = new Student();
                    toAdd.Id = resultData.Tables[0].Rows[i].Field<int>("Id");
                    toAdd.Name = resultData.Tables[0].Rows[i].Field<string>("Name");


                    allTeachers.Add(toAdd);
                }

            }
            return allTeachers;
        }

        public Student GetById(int id)
        {
            Student toReturn = null;
            using (SqlConnection connection = new SqlConnection(_conString))
            {
                SqlDataAdapter adapter = new SqlDataAdapter("SELECT Id, Name FROM students WHERE Id =" + id, connection);
                DataSet resultData = new DataSet();
                adapter.Fill(resultData);
                if (resultData.Tables[0].Rows.Count == 1)
                {
                    toReturn = new Student();
                    toReturn.Id = int.Parse(resultData.Tables[0].Rows[0]["Id"].ToString());
                    toReturn.Name = resultData.Tables[0].Rows[0].Field<string>("Name");

                }
            }
            return toReturn;
        }
    }
}
