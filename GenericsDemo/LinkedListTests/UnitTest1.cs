using NUnit.Framework;
using LinkedList;
using System.Linq;
using System;

namespace LinkedListTests
{
    
    public class Tests
    {
        DavidLinkedList<string> list;
        [OneTimeSetUp]
        public void SetUpAllTests()
        {

        }

        [OneTimeSetUp]
        public void SecondSetUp()
        {

        }
        [SetUp]
        public void Setup()
        {
            list = new DavidLinkedList<string>();
        }

        [Test]
        public void LinkedListAdd()
        {

            list.Add("a");
            Assert.AreEqual(1, list.Count());
            Assert.AreEqual("a", list.First());

            list.Add("b");
            Assert.AreEqual(2, list.Count());
            Assert.AreEqual("a", list.First());

            Assert.AreEqual("b", list.Skip(1).First());

            //var enumerator = list.GetEnumerator();
            //enumerator.MoveNext(); 
            //Assert.AreEqual("a", enumerator.Current);
        }

        [Test]
        public void LinkedListAddOtherWay(
            [Values("one","")]string first,
            [Values("two", "")] string second)
        {

            list.Add(first);
            Assert.AreEqual(1, list.Count());
            Assert.AreEqual(first, list.First());

            list.Add(second);
            Assert.AreEqual(2, list.Count());
            Assert.AreEqual(first, list.First());
            Assert.AreEqual(second, list.Skip(1).First());   
        }

        [Test]
        public void LinkedListRemove()
        {
            list.Add("a");

            Assert.AreEqual(1, list.Count());
            Assert.AreEqual("a", list.First());

            list.Add("b");
            list.Remove("a");
            Assert.AreEqual(1, list.Count());
            Assert.AreEqual("b", list.First());
        }



        [TestCase ("one", "two")]
        [TestCase("", "")]
        
        public void LinkedListRemoveOtherWay(string first, string second)
        {
            list.Add(first);

            Assert.AreEqual(1, list.Count());
            Assert.AreEqual(first, list.First());

            list.Add(second);
            list.Remove(first);
            Assert.AreEqual(1, list.Count());
            Assert.AreEqual(second, list.First());
        }


        [Test]
        public void LinkedListNotFound()
        {
            list.Add("a");

            Assert.AreEqual(1, list.Count());
            Assert.AreEqual("a", list.First());

            list.Add("b");
            Assert.Throws<ItemNotFoundException>(() => list.Remove("c")); 
        }

        [Test]
        public void LinkedListAddNull()
        {
            Assert.Throws<ArgumentNullException>(() => list.Add(null));
        }

    }
} 