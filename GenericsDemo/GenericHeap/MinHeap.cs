using System;
using System.Collections.Generic;

namespace GenericHeap
{

    //what is a heap?
    //heap property - each "node" has 2 children,
    //each child is (less for maxheap/greater for minheap) than the parent
    //  therefore top-most node is largest/smallest, respectively


    //parents & children in an array/list

    //                  0
    //       1                    2
    //    3     4              5    6
    //   7 8   9 X

    // LeftChildIndex( int parentIndex ) => parentIndex * 2 + 1;
    // RightChildIndex( int parentIndex ) => parentIndex * 2 + 2;
    // ParentIndex( int childIndex ) => (childIndex - 1) / 2;


    //https://en.wikipedia.org/wiki/Binary_heap
    public class MinHeap<T> where T : IComparable<T>
    { 

        //every incoming object will implement IComparable<T>
        //CompareTo semantics:

        //this.CompareTo( that )
        //  -  this comes "before" that or this < that
        //  0  this == that
        //  +  this comes "after" that or this > that

        List<T> _allElements = new List<T>();

        public void Add( T toAdd)
        {
            _allElements.Add(toAdd);
            SiftUp();
        }

        
    }
}
