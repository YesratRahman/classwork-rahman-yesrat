﻿using System;
namespace VendingMachine.Exceptions
{
    public class InsufficientFundsException : Exception
    {
        public InsufficientFundsException(string message): base(message) { }


        public InsufficientFundsException(string message, Exception innerException)
            : base(message, innerException) { }

    }
} 