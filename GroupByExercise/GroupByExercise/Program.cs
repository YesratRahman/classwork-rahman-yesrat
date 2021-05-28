using System;
using System.Collections.Generic;

namespace GroupByExercise
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Person> allPeople = new List<Person>();
            Random rng = new Random();
            for (int i = 0; i < 1000000; i++)
            {
                allPeople.Add(new Person(rng.Next(), (City)rng.Next(81)));
            }

            Console.WriteLine(allPeople);

            var groupedPeopleByCity = GroupByCity(allPeople);

            foreach (City homeCity in groupedPeopleByCity.Keys)
            {
                //Console.WriteLine(homeCity); 
                Console.WriteLine(homeCity + " contains " + groupedPeopleByCity[homeCity].Count + " people.");
            }


        }

        private static Dictionary<City, List<Person>> GroupByCity(List<Person> allPeople)
        {
            Dictionary<City, List<Person>> groupByCity = new Dictionary<City, List<Person>>();


            for (int i = 0; i < allPeople.Count; i++)
            {
                List<Person> people = new List<Person>
                {
                    allPeople[i]
                };

                if (groupByCity.ContainsKey(allPeople[i].HomeCity))
                {
                    groupByCity[allPeople[i].HomeCity].Add(allPeople[i]);
                    continue;
                }
                else
                {
                    groupByCity.Add(allPeople[i].HomeCity, people);

                }
            }
            return groupByCity;
        }
    }
}
