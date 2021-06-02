using System;
using System.Collections.Generic;
using GenericHeap;
using LinkedList;

namespace GenericsDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            DavidLinkedList<string> firstList = new DavidLinkedList<string>();

            firstList.Add("Alice");
            firstList.Add("Bob");
            firstList.Add("Clarice");
            firstList.Add("David");
            firstList.Add("Elizabeth");

            foreach (string temp in firstList)
            {
                Console.WriteLine(temp);
            }

            foreach (string temp in firstList)
            {
                Console.WriteLine(temp);
            }


            foreach (string temp in firstList)
            {
                Console.WriteLine(temp);
            }

            MinHeap<int> heapList = new MinHeap<int>();
            heapList.Add(20);
            heapList.Add(19);
            heapList.Add(36);

            Console.WriteLine(heapList.Peek());
            heapList.Remove(20);
            heapList.Remove(36);
            heapList.RemoveMin();
            heapList.Add(15);

            heapList.Add(16);
            heapList.Add(50);
            heapList.Add(12);
            heapList.Pop(); 
        }
    }
}
