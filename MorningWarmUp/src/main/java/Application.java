//import java.util.Random;

public class Application {
    public static void main(String[] args) {

    }
}


//        System.out.println(canBalance(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples1(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples1(new int[]{5,2,3}));
//        System.out.println(noTriples(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples(new int[]{5,2,3}));
//    }

//    public static boolean canBalance(int[] nums) {
//        //return true if there is any place where we can split the array
//        //each side of the array's sum is equal to each other
//        int rightSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            rightSum += nums[i];
//        }
//        int leftSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            leftSum += nums[i];
//            rightSum -= nums[i];
//            if (leftSum == rightSum) return true;
//        }
//        return false;
//    }
//
//    //return true if there is no truples in the array
//    public static boolean noTriples1(int[] nums){
//        for(int i = 0; i < nums.length - 2; i++) {
//            if(nums[i+1] == nums[i] && nums[i+2] == nums[i])
//                return false;
//        }
//
//        return true;
//    }
//    public static boolean noTriples(int[] array){
//        int temp = array[0];
//        boolean isDouble = false;
//        for(int i = 1; i < array.length; i++ ){
//            if(array[i] == temp){
//                if(isDouble){
//                    return false;
//                }
//                isDouble = true;
//            }
//            else{
//                isDouble = false;
//            }
//            temp = array[i];
//        }
//        return true;
//    }
//
//}
//
//        //bitwise operation
//        int mask = 1;
//
//        Random rang = new Random();
//        int ranNum = rang.nextInt();
//
//        for(int i = 0; i < 32; i++){
//            System.out.println(ranNum & mask);
//            mask <<= 1;
//        }
//
//
//        System.out.println(middleOfThree(1, 2, 3));
//        System.out.println(middleOfThree(1, 3, 2));
//        System.out.println(middleOfThree(2, 1, 3));
//        System.out.println(middleOfThree(2, 3, 1));
//        System.out.println(middleOfThree(3, 1, 2));
//        System.out.println(middleOfThree(3, 2, 1));
//        System.out.println(macNum(3, 2, 1));
//
//        fizzBuzz();
//        fizzBuzz1();
//
//
//        //1-d Arrays:
//        int[] oneDim = new int[10];
//
//        //2-d arrays:
//        int[][] twoDim = new int[10][];
//        for (int i = 0; i < twoDim.length; i++) {
//            twoDim[i] = new int[10];
//        }
//        int[][] quick = {
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
//        };
//        int[][] quick2 = {
//                {11, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {12, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 1234, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {11, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {12, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 1234, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
//        };
//
//        System.out.println(quick2[0][0]);
//        System.out.println(quick2[2][3]);
//
//        for (int row = 0; row < quick2.length; row++) {
//            for (int col = 0; col < quick2[row].length; col++) {
//                System.out.print(quick2[row][col] + " ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 0; i < 100; i++){
//            int row = i / 10;//(10 is the width of the row);
//            int col = i % 10;
//            System.out.println(quick2[row][col]);
//        }
//    }
//    public static int computeIndex(int row, int col){
//        return 10 * row + col;
//    }
//
//    public static int middleOfThree(int a, int b, int c) {
//        if (a > b) {
//            if (c > a) {
//                return a;
//            } else if (c > b) {
//                return c;
//            } else {
//                return b;
//            }
//        } else {
//            if (a > c) {
//                return a;
//
//            } else if (b > c) {
//                return c;
//
//            } else {
//                return b;
//
//            }
//        }
//    }
//    public static int macNum(int a, int b, int c ){
//        int maxNum = a;
//        if(b >c ){
//            maxNum = b;
//        }
//        if(c > maxNum){
//            maxNum = c;
//        }
//        return maxNum;
//    }
//
//    public static void fizzBuzz(){
//        for(int i =0; i < 100; i++){
//            if(i % 3 != 0 && i % 5 != 0){
//                System.out.print("i");
//            }
//            if(i % 3 == 0){
//                System.out.print("fizz");
//            }
//            if(i % 5 == 0){
//                System.out.print("buzz");
//            }
//            System.out.println();
//        }
//    }
//    public static void fizzBuzz1(){
//        for(int i =0; i < 100; i++){
//            if(i % 3 == 0 && i % 5 == 0){
//                System.out.println("fizzbuzz");
//            }
//            else if(i % 3 == 0){
//                System.out.print("fizz");
//            }
//            else if(i % 5 == 0){
//                System.out.print("buzz");
//            }
//            System.out.println(i);
//        }
//    }
//}

//We'll say that a "mirror" section in an array is a group of contiguous elements
// such that somewhere in the array, the same group appears in reverse order.
// For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3
// (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
//
//
//maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
//maxMirror([1, 2, 1, 4]) → 3
//maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
//    public int maxMirror(int[] nums) {
//        int totalLength = 0;
//        for(int leftMatch = 0; leftMatch < nums.length; leftMatch++){
//            for(int rightMatch = nums.length - 1; rightMatch >= leftMatch; rightMatch--){
//
//                int lengthSm = 0;
//                int leftIndex, rightIndex = 0;
//                Boolean isMatch = false;
//
//                if(nums[leftMatch] == nums[rightMatch]){
//                    isMatch = true;
//                }
//                while(isMatch){
//                    lengthSm++;
//                    leftIndex = leftMatch + lengthSm;
//                    rightIndex = rightMatch - lengthSm;
//
//                    isMatch =(rightIndex >= 0) && (nums.length > leftIndex) &&
//                            (nums[leftIndex] == nums[rightIndex]);
//                }
//                if(lengthSm > totalLength){
//                    totalLength = lengthSm;
//                }
//            }
//        }
//        return totalLength;
//    }

//    public int maxMirror(int[] nums) {
//        int maxLength = 0;
//        for(int i = 0; i < nums.length; i++){ //front loop
//            for(int j = nums.length -1; j >= 0; j--){//back loop
//
//                if(nums[i] == nums[j]){
//                    //we've found the match of at least length 1
//                    //it could be the max, but we don't know
//
//                    //another length variable to hold the least/small length inside the loop
//                    int currentLength = 1;
//                    for(int offset = 1;
//                        i + offset < nums.length && j - offset >= 0;
//                        offset++){
//                        if(nums[i+offset] == nums[j-offset]){
//                            currentLength++;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    if(currentLength > maxLength){
//                        maxLength = currentLength;
//                    }
//                }
//
//            }
//
//        }
//        return maxLength;
//
//    }