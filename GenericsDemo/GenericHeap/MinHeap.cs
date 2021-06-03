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

    // 2 0
    //
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

      
        public void Add(T toAdd)
        {
            _allElements.Add(toAdd);
            SiftUp(_allElements.Count - 1);
        }
        public bool checkHeap()
        {
            if (_allElements.Count < 2) return true;
            for (int i = 0; i <= (_allElements.Count - 2) / 2; i++)
            {
                int leftChildIndex = i * 2 + 1;
                int rightChildIndex = i * 2 + 2;
                T leftChild = _allElements[leftChildIndex];
                if (_allElements[i].CompareTo(leftChild) > 0)
                {
                    return false;
                }
                if (rightChildIndex < _allElements.Count)
                {
                    T rightChild = _allElements[rightChildIndex];
                    if (_allElements[i].CompareTo(rightChild) > 0)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        public void Remove(T toRemove)
        {
            //we're looking for a CompareTo() == 0
            for (int i = 0; i < _allElements.Count; i++)
            {
                if (toRemove.CompareTo(_allElements[i]) == 0)
                {
                    _allElements.RemoveAt(i);
                }
                Heapify();
            }


        }

        public T Peek()
        {
            if (_allElements.Count > 0) return _allElements[0];
            return default(T);
        }

        public T Pop()
        {
            T toReturn = default(T);
            if (_allElements.Count > 0) toReturn = _allElements[0];

            //todo: actually remove the top node
            //swap with the last element
            //remove the last element
            //heapify()
            
            _allElements[0] = _allElements[_allElements.Count - 1];
            _allElements.RemoveAt(_allElements.Count - 1);
            Heapify();

            return toReturn;
        }

        private void SiftUp(int val)
        {
            int parentIndex;
            
            if (val != 0)
            {
                parentIndex = (val - 1) / 2;
                if (val > 0 && _allElements[val].CompareTo(_allElements[parentIndex]) == -1)
                {
                    Swap(parentIndex, val); 
                    SiftUp(parentIndex);
                }
            }
        }


        private void Heapify()
        {
            int parentIndex = 0;
            while (parentIndex < _allElements.Count)
            {
                int min = parentIndex;
                int leftChildIndex = 2 * parentIndex + 1;
                int rightChildIndex = 2 * parentIndex + 2;

                if (leftChildIndex < _allElements.Count && _allElements[leftChildIndex].CompareTo(_allElements[min]) == -1)
                {
                    min = leftChildIndex;
                }

                if (rightChildIndex < _allElements.Count && _allElements[rightChildIndex].CompareTo(_allElements[min]) == -1)
                {
                    min = rightChildIndex;
                } 

                if (min == parentIndex) break;

                else
                {
                   
                    Swap(parentIndex, min);
                    parentIndex = min;
                }
            }
        }

        private void Swap(int first, int second)
        {
            T temp = _allElements[first];
            _allElements[first] = _allElements[second];
            _allElements[second] = temp;
        }

        public T RemoveMin()
        {
            T value = _allElements[0];
            _allElements[0] = _allElements[_allElements.Count - 1];
            _allElements.RemoveAt(_allElements.Count - 1);

            int parentIndex = 0;


            while (parentIndex < _allElements.Count)
            {
                int min = parentIndex;
                int leftChildIndex = parentIndex * 2 + 1;
                int rightChildIndex = parentIndex * 2 + 2;

                if (leftChildIndex < _allElements.Count && _allElements[leftChildIndex].CompareTo(_allElements[min]) == -1)
                {
                    min = leftChildIndex;
                }

                if (rightChildIndex < _allElements.Count && _allElements[rightChildIndex].CompareTo(_allElements[min]) == -1)
                {
                    min = rightChildIndex;
                }

                if (min == parentIndex) break;
                else
                {
                    Swap(parentIndex, min);
                }

            }

            return value;


        }

    }
}

