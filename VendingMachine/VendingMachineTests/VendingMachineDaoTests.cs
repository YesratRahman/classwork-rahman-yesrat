using System.Collections.Generic;
using System.IO;
using NUnit.Framework;
using VendingMachine.Daos;
using VendingMachine.Models;

namespace VendingMachineDaoTests
{
    public class Tests
    {
        private IVendingMachineDao _machineDao;
        private static string _testFile = "../../../../VendingMachine/Test.txt";

        private static string _seedFile = "../../../../VendingMachine/Seed.txt";

        [OneTimeSetUp]
        public void SetupOnce()
        {
            _machineDao = new VendingMachineFileDao(_testFile);
        }

        [SetUp]
        public void Setup()
        {
            File.Delete(_testFile);
            File.Copy(_seedFile, _testFile); 
        }

        [Test]
        public void GetAllCandies()
        {
            List<Candy> toTest = _machineDao.GetAllCandies();
            Assert.AreEqual(4, toTest.Count);
            Candy candy = new Candy("Necco Wafers Candy", 4, 2.00m);
            Assert.AreEqual(candy.Name, toTest[0].Name);
            Assert.AreEqual(candy.Quantity, toTest[0].Quantity);
            Assert.AreEqual(candy.Price, toTest[0].Price);

            candy = new Candy("Nerds Candy",11,1.50m);
            Assert.AreEqual(candy.Name, toTest[1].Name);
            Assert.AreEqual(candy.Quantity, toTest[1].Quantity);
            Assert.AreEqual(candy.Price, toTest[1].Price);

            candy = new Candy("Milky Way Candy Bar",18,1.25m);
            Assert.AreEqual(candy.Name, toTest[2].Name);
            Assert.AreEqual(candy.Quantity, toTest[2].Quantity);
            Assert.AreEqual(candy.Price, toTest[2].Price);

            candy = new Candy("Hershey's Kisses",10,2.00m);
            Assert.AreEqual(candy.Name, toTest[3].Name);
            Assert.AreEqual(candy.Quantity, toTest[3].Quantity);
            Assert.AreEqual(candy.Price, toTest[3].Price);
        }

        //[TestCase("Necco Wafers Candy", 4, 2)]
        //[TestCase("Nerds Candy", 11, 1.50)]
        //[TestCase("Milky Way Candy Bar", 18, 1.25)]
        //[TestCase("Hershey's Kisses", 10, 2.00)]
        
        //public void RemoveCandyUpdatesVendingMachine(string candyName, int index, int expectedQty)
        //{
        //    _machineDao.UpdateCandy(candyName);
        //    Assert.AreEqual(expectedQty, _machineDao.GetAllCandies()[index].Quantity);
        //}
    }
}