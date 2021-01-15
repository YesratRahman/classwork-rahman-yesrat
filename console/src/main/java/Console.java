import java.util.Scanner;
public class Console {

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

    public static int readInt(String prompt, int min, int max) {

        int value = Integer.MIN_VALUE; //need the input scanner
        boolean valid = false;
        while (!valid) {
            value = readInt(prompt);
            valid = min <= value && max >= value;
        }
        return value;
    }

    public static double readDouble(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        Double parsedInt = Double.NaN;
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedInt = Double.parseDouble(userInput);
                valid = true;
            } catch (NumberFormatException ex) {
                //keep looping
            }
        }
        return parsedInt;
    }
    public static double readDouble(String msg, double min, double max) {

        Double value = Double.NaN;
        boolean valid = false;
        while (!valid) {
            value = readDouble(msg);
            valid = min <= value && max >= value;
        }
        return value;
    }


}