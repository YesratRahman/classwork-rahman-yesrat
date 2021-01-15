import java.util.Random;

//Singleton Pattern
//Single static instance of something inside a class
//which we than use throughout
public class Rng {
    static Random rng = new Random();

    public static int readInt(int incMin, int incMax){
        //this call takes an exclusive upper bound (or max)
        //returns a number between 0 and that bound -1
        //rng.nextInt()

        int read = incMin + rng.nextInt((incMax - incMin) + 1);
        //incMin to (incMax + incMin)
        return read;
    }

    public static double randDouble (Double incMin, double incMax) {
        double rand = incMin + rng.nextDouble() * (incMax - incMin);   // range is rincMin to (incMax + incMin)
        return rand;
    }

    public static boolean coinFlip() {
        return rng.nextBoolean();
    }

}
