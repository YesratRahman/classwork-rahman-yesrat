using System;
using System.Collections.Generic;
using NUnit.Framework;
using VendingMachine.Daos;
using VendingMachine.Models;
using VendingMachine.Services;

namespace VendingMachineTests
{
    public class VendingMachineServiceTests
    {
        private static readonly IVendingMachineService _service = new VendingMachineService(new VendingMachineInMemDao());
        [Test]
        public void GetAllCandies()
        {
            List<Candy> toTest = _service.GetAllCandies();
            Assert.AreEqual(4, toTest.Count);
            Candy candy = new Candy("Necco Wafers Candy", 4, 2.00m);
            Assert.AreEqual(candy.Name, toTest[0].Name);
            Assert.AreEqual(candy.Quantity, toTest[0].Quantity);
            Assert.AreEqual(candy.Price, toTest[0].Price);

            candy = new Candy("Nerds Candy", 11, 1.50m);
            Assert.AreEqual(candy.Name, toTest[1].Name);
            Assert.AreEqual(candy.Quantity, toTest[1].Quantity);
            Assert.AreEqual(candy.Price, toTest[1].Price);

            candy = new Candy("Milky Way Candy Bar", 18, 1.25m);
            Assert.AreEqual(candy.Name, toTest[2].Name);
            Assert.AreEqual(candy.Quantity, toTest[2].Quantity);
            Assert.AreEqual(candy.Price, toTest[2].Price);

            candy = new Candy("Hershey's Kisses", 10, 2.00m);
            Assert.AreEqual(candy.Name, toTest[3].Name);
            Assert.AreEqual(candy.Quantity, toTest[3].Quantity);
            Assert.AreEqual(candy.Price, toTest[3].Price);
        }
    }
}
