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

        }
    }
}