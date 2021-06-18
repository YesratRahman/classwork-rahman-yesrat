using System;
using System.Runtime.Serialization;

namespace CourseManager.Exceptions
{
    [Serializable]
    internal class StudentNotFoundException : Exception
    {
        public StudentNotFoundException()
        {
        }

        public StudentNotFoundException(string message) : base(message)
        {
        }

        public StudentNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected StudentNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}