public class Application {
    public static void main(String[] args){

       int number =  Console.readInt("Please enter a number");
        System.out.println(number);


//Uniary operator = takes a single operand
boolean inClass = false;
boolean absent = !inClass;

//&& and operator - both operands must be True for the output to be true
// false otherwise

boolean payingAttention = true;
boolean goodStudent = inClass && payingAttention;

// || or operator - both operands must be FALSE for the output to be false
// true otherwise

// !(a && b) == !a || !b DeMorgan's
// !(a || b) == !a && !b

//Bitwise operations
int num = 57;
int mask = 1;
if((num & mask ) == 1){
    //the number is odd
        }

// Comparison Operators
// Numeric is inputs, boolean is output
        // == equality returns true if the operand on the left is the same as the right
        // When used an OBJECTS, however, this will return true if they're in the same
        // memory location
        // as a result, we only want to use this on primitives
        // use .equals() to compare objects

        // != equality returns true if the operand on the left is not the same
        // as the right
        // similar notes regarding objects as above
        // when not working with primitives, use !????.equals()

        // >, >= greater than / greater than or equal to returns true if the left operand is greater

        // <, <= less than / less than or equal to returns true if the left operand is less

        // in some language, != can be represented as <>

        //While loop
        // keep repeating as long as the boolean evaluates as true
        // Typically we use while loop when we don't know how many times we have to loop through
        while ( true) {
            break; //This exits the loop no matter what, regarding of the condition at the top
                    // can be a bit of a "code smell"
                    // causes a jump in execution that is not really reflected by brackets
        }

        //echo the user input as long as they type even numbers
        // otherwise go forever
        while(true){
            int toCheck = Console.readInt("Please enter a number");
            if (toCheck %2 != 0) {
                continue; //Skip the rest of the loop and goes back to the top
                            //and reaches the condition
                            //continue is not a good choice
            }
            System.out.println(toCheck);
        }

        //do while always loops at least once

        int userChoice = 5;
        do{
            //print our main menu
            //We'll pretend this works
            //and that option 5 is quit
            userChoice = Console.readInt("Please enter your selection ", 1 , 5);
            //do something with choices 1-4 if that's what they entered
        } while(userChoice != 5);

        //for loop
        //used when the number of iteration is known
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        //start with 1 and keep looping unlike we get above the million

        for(int i = 1; i <= 100000; i = i*2){
            System.out.println(i);
        }

        boolean $ = true;

        //this loop is so bad, it's crying
        for ( ;$ ; ){

        }

        // equivalent
        while($){

        }

        //Array
        //the most basic collection of data
        //arrays are 0 indexed
        //      the first piece of data is found at index 0 rather than 1
        //      the max index is the size -1

        //declaring an array variable
        // type of each element, followed by EMPTY square brackets, then the name
        String[] className;    //the type of ClassName is String[]

        //initializing an array
        // we use the new keyword to allocate memory space
        // and now in the square brackets we'll provide a size

        className = new String[14];

        //arrays can not be resized once created, the variable has to be overwritten with a bigger array

        String[] temp = new String[14];

        //first index = 0
        //index must stay less than the length (because the max index is lenght -1)
        // since we are going to copy each "cell" or "element" we increase by one

        for(int i = 0; i < temp.length; i++) {
            // to access a single element in an array, we'll use the variable name and
            //square brackts with an integer expression inside
            temp[i] = className[i];
        }
        className = new String[15];
        for(int i = 0; i < temp.length; i++) {
            className[i] = temp[i];
        }
        //now we have room for one more students
        // at position 14 (15 elements)

        //quick initialization
        int[] ages = { 25, 32, 14, 33  };

        }
    }

