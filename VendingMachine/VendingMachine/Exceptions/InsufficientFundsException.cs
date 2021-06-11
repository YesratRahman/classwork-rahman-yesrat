using System;
namespace VendingMachine.Exceptions
{
    public class InsufficientFundsException : Exception
    {
        public InsufficientFundsException() { }

        public InsufficientFundsException(string message, Exception innerException)
            : base(message, innerException) { }

    }
} 