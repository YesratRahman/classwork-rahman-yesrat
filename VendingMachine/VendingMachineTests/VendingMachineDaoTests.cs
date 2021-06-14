using System.IO;
using NUnit.Framework;
using VendingMachine.Daos;

namespace VendingMachineDaoTests
{
    public class Tests
    {
        private IVendingMachineFileDao _fileDao;
        private static string _testFile = "../../../../VendingMachine/Test.txt";

        private static string _seedFile = "../../../../VendingMachine/Seed.txt";

        [OneTimeSetUp]
        public void SetupOnce()
        {
            _fileDao = new VendingMachineFileDao(_testFile);
        }

        [SetUp]
        public void Setup()
        {
            File.Delete(_testFile);
            File.Copy(_seedFile, _testFile); 
        }

        [Test]
        public void Test1()
        {
            Assert.Pass();
        }
    }
}