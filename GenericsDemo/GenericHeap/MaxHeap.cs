using System;
using System.Collections.Generic;

namespace GenericHeap
{
    public class MaxHeap<T> where T : IComparable<T>
    {
        List<T> _allElements = new List<T>();


        public void Add(T toAdd)
        {
            _allElements.Add(toAdd);
            SiftDown();


        }

        private void SiftDown()
        {
            throw new NotImplementedException();
        }

        public void Remove(T toRemove)
        {
            int index = _allElements.IndexOf(toRemove);
            int lastIndex = _allElements.Count - 1;

            _allElements[index] = _allElements[lastIndex];
            _allElements.RemoveAt(lastIndex);

            SiftDown();

        }

        public T Peek()
        {
            if (_allElements.Count > 0) return _allElements[0];
            return default(T);
        }

        public T Pop()
        {
            throw new NotImplementedException();

        }

        private void Swap(int first, int second)
        {
            T temp = _allElements[first];
            _allElements[first] = _allElements[second];
            _allElements[second] = temp;
        }
    }

}
