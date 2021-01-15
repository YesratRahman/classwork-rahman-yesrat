import java.util.Scanner;
public class App {
    //program entry point (this method is special)
    //public - controls  visibility
    //   allow the function to be called from any package

    //static - associate this with a class rather than INSTANCE of that class
    //   for now always use publiv and static

    // void - return type, void means return nothing
    // otherwise, it is a data type

    // main - method name, by convention use cameCase (not PascalCase)

    //(String[] args) - parentheses contain a comma separated list of parameters
    //       parameters are variables which holds the input to a function
    //       BEFORE the method is called
    //   The data passed INTO the parameters 

    public static void main(String[] args){
//        int[] testArray = {82, 95, 71, 6, 34};
//
//        int min = Aggregate.min(testArray);
//        int max = Aggregate.max(testArray);
//        int sum = Aggregate.sum(testArray);
//        double avg = Aggregate.average(testArray);
//        double div = Aggregate.standardDeviation(testArray);
//
//        System.out.println(min);  // 6
//        System.out.println(max);  //95
//        System.out.println(sum);  //288
//        System.out.println(avg);  //57.6
//        System.out.println(div);  //36.719

        final int ROCK = 1;
        final int SCISSORS = 2;
        final int PAPER = 3;

        int computerDecision = getComputerChoice();
        int userDecision = getUserChoice();

        System.out.print("user: " + printChoice(userDecision));
        switch(userDecision) {

            case ROCK:
                if(computerDecision == ROCK){
                    System.out.println("That's a Tie!");
                }
                else if(computerDecision == SCISSORS ){
                    System.out.println("Congrats! You won");
                }
                else{
                    System.out.println("Sorry,You lost!");
                }
                break;
            case SCISSORS:
                if(computerDecision == ROCK){
                    System.out.println("Sorry,You lost!");
                }
                else if(computerDecision == SCISSORS ){
                    System.out.println("That's a Tie!");
                }
                else{
                    System.out.println("Congrats! You won");
                }
                break;
            case PAPER:
                if(computerDecision == ROCK){
                    System.out.println("Congrats! You won");
                }
                else if(computerDecision == SCISSORS ){
                    System.out.println("Sorry,You lost!");
                }
                else{
                    System.out.println("That's a Tie!");
                }
                break;

            default:

        }


    }


   public static int getComputerChoice(){

        return Rng.readInt(1, 3) ;
   }

   public static int  getUserChoice(){

       return  readInt("Choose 1 for Rock, 2 for Scissors, choose 3 for Paper: ");
   }

    public static void printChoice(int choice){
        if(choice == 1){
            System.out.println("Your selected Rock!");
        }
        if(choice == 2){
            System.out.println("Your selected Scissors!");
        }
        else {
            System.out.println("Your selected Paper!");

        }

    }

    public static void print(String prompt) {
        System.out.println(prompt);
    }



    public static int readInt(String msg) {
        Scanner input = new Scanner(System.in);

        boolean valid = false;
        int parsedInt = Integer.MIN_VALUE;

        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedInt = Integer.parseInt(userInput);
                valid = true;
            } catch (NumberFormatException ex) {
            }
        }
        return parsedInt;
    }

}
