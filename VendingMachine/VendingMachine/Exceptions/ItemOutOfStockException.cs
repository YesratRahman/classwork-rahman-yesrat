using System;
namespace VendingMachine.Exceptions
{
    public class ItemOutOfStockException : Exception
    {
        public ItemOutOfStockException(string message) : base(message)
        {

        }
        public ItemOutOfStockException(string message, Exception innerException) :
            base(message, innerException)
        {

        }
    }
} 