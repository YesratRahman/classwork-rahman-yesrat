using System;
using NUnit.Framework;
using WidgetSales;
using System.Linq; 

namespace WidgetSalesTests
{
    public class InMemInventoryDaoTests
    {
        InMemInventoryDao _toTest;

        [SetUp]
        public void Setup()
        {
            _toTest = new InMemInventoryDao();
        }

        [TestCase( "lumber", 1, "building supplies", 1)]
        public void TestAddWidgetInventory(string name, int qty, string cat, int expectedId )
        {
            WidgetInventory toAdd = new WidgetInventory {
                Category = cat,
                Name = name,
                StockCount = qty };
            int addedId = _toTest.Add(toAdd);

            WidgetInventory savedWidget = _toTest.GetByName(name);


            Assert.AreEqual(expectedId, addedId);
            Assert.AreEqual(savedWidget.Name, name);
            Assert.AreEqual(savedWidget.Category, cat);
            Assert.AreEqual(savedWidget.Id, expectedId);
            Assert.AreEqual(savedWidget.StockCount, qty);
        }

        [Test]
        public void ShouldNotBeAbleToChangeAddedWidget()
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Category = "test",
                Name = "test",
                StockCount = 1
            };

            _toTest.Add(toAdd);

            toAdd.Name = "x";

            var storedWidget = _toTest.GetByName("test");
            Assert.AreEqual("test", storedWidget.Name);
        }

        [Test]
        public void ShouldNotBeAbleToAddNullWidget()
        {
            Assert.Throws<ArgumentNullException>(() => _toTest.Add(null));

        }

        [TestCase(null, 1, "building supplies")]
        public void ShouldNotbeAbleToAddWidgetByNullName(string name, int qty, string cat)
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Category = cat,
                Name = name,
                StockCount = qty
            };
            Assert.Throws< ArgumentNullException>(() => _toTest.Add(toAdd));

        }

        [TestCase("lamber", 1, null)]
        public void ShouldNotbeAbleToAddWidgetByNullCategory(string name, int qty, string cat)
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Category = cat,
                Name = name,
                StockCount = qty
            };
            Assert.Throws<ArgumentNullException>(() => _toTest.Add(toAdd));
        }

        [TestCase("lamber", -1, "building supplies")]
        public void ShouldNotbeAbleToAddWidgetByInvalidStockCount(string name, int qty, string cat)
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Category = cat,
                Name = name,
                StockCount = qty
            };
            Assert.Throws<ArgumentException>(() => _toTest.Add(toAdd));
        }

        [TestCase("lamber")]
        [TestCase("")]
        public void RemoveWidgetByName(string name)
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Name = name,
                Category = "building supplies",
                StockCount = 1
            };

            _toTest.Add(toAdd);
            _toTest.RemoveWidgetByName(name);
            Assert.AreEqual(null, _toTest.GetByName(name)); 
            
        }

        [TestCase(null)]
        public void RemoveWidgetByNullName(string name)
        {
            WidgetInventory toAdd = new WidgetInventory
            {
                Name = name,
                Category = "building supplies",
                StockCount = 1
            };

            _toTest.Add(toAdd);
            Assert.Throws<ArgumentNullException>(() => _toTest.RemoveWidgetByName(name));
            

        }

    }
}