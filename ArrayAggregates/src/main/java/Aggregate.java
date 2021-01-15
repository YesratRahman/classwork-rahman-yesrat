public class Aggregate {
    public static int min(int[] arr){
        //find the minimum number and return it
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr){
        //find the maximum number and return it

        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int sum(int[] arr){
        //find the sum of all the numbers in the array
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static double average(int[] arr){
        //find the sum of all the numbers in the array
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+= arr[i];
        }
        double avg =  (double) sum/arr.length;
        return avg;
    }

    public static double standardDeviation(int[] arr){
        //find the std dev of all the numbers in the array
        //first compute the average
        //then add the square of the Difference between the average and each number
        //then take the square root (you will need to google how to get square root in java)
        double  sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+= arr[i];
        }
        double avg =  (double) sum/arr.length;

        double div = 0.0;
        for (int i = 0; i < arr.length; i++){
            div += Math.pow((arr[i] - avg), 2);
        }
        return Math.sqrt(div/ (arr.length -1)) ;
    }


}
