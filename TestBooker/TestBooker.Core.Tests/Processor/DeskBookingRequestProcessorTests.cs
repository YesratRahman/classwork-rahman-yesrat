using System;
using Xunit;

namespace TestBooker.Core.Tests.Processor
{
    public class DeskBookingRequestProcessorTests
    {
        [Fact]
        public void ShouldReturnDeskBookingResultWithRequestValues()
        {
            //Arrange
            var request = new DeskBookingRequest
            {
                FirstName = "Thomas",
                LastName = "Hober",
                Email = "thomas@gmail.com",
                DateTime = new DateTime(2021, 06, 9)
            };


            var processor = new DeskBookingRequestProcessor();

            //Act
            DeskBookingRequest result = processor.BookDesk(request);

            //Assert

            Assert.NotNull(request); 
        }

    }
} 
