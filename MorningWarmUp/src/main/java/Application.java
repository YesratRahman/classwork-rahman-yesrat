//import java.util.Random;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(digitReverse(321));
        System.out.println(digitReverse(1));
        System.out.println(digitReverse(11));
        System.out.println(digitReverse(2000));
        System.out.println(digitReverse(20001));
        System.out.println(digitReverse(-321));
        System.out.println(digitReverse(0));


    }

    //123->321
    //2001->2002
    //2000->2
    //2->2
    public static int digitReverse(int toFlip){
        boolean isNeg = false;
        int reverseNum = 0;
        if(toFlip < 0){
            isNeg = true;
        }

        if(isNeg){
            toFlip = toFlip *  (-1);
        }
        while(toFlip > 0){
            reverseNum *= 10;
            reverseNum = reverseNum +  toFlip % 10;
            toFlip /=10;
        }
        return isNeg == true? reverseNum * (-1) : reverseNum;
    }

    }

//        //New Problem
//
////        The following iterative sequence is defined for the set of positive integers:
////
////        n → n/2 (n is even)
////        n → 3n + 1 (n is odd)
////
////        Using the rule above and starting with 13, we generate the following sequence:
////
////        13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
////        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
////        Although it has not been proved yet (Collatz Problem), it is thought that
////        all starting numbers finish at 1.
////        Which starting number, under one million, produces the longest chain?
//
//        System.out.println(getChainSteps(837799));
//        System.out.println(getChainSteps(13));
//
//        long sequence;
//        long chainLength = 0;
//        long num = 0;
//
//        for(int i = 2; i <= 1000000; i++){
//            int length = 1;
//
//            sequence = i;
//            while(sequence != 1){
//                if((sequence %2) != 0){
//                    sequence = sequence * 3 +1;
//                }
//                else{
//                    sequence = sequence /2;
//                }
//                length++;
//            }
//            if(chainLength < length) {
//                chainLength = length;
//                num = i;
//            }
//        }
//        System.out.println(num + " Produces the longest chain. ");
//        System.out.println(chainLength + " is the chain length ");
//
//
//    }
//
//    public static int getChainSteps(long sequence){
//        List<Long> list = new ArrayList<>();
//        int length = 0;
//        while (sequence != 1){
//            list.add(sequence);
//            if((sequence % 2) != 0){
//                sequence = sequence * 3 + 1;
//            }
//            else{
//                sequence = sequence / 2;
//            }
//
//        }
//        length = list.size() + 1 ;
//        return length ;
//    }
//}

// End Problem

//New Problem
//        //The list type is an interface
//        //The concrete class we'll use is an ArrayList
//
//        List<String> testList = new ArrayList<>();
//        testList.add("Bob");
//        testList.add("Bobby");
//        testList.add("Robert");
//        testList.add("Roberto");
//        testList.add("Alice");
//        testList.add("Alica");
//
//        String[] allNames = testList.toArray(new String[0]);
//
//        //how to make a map with values that are lists
//
//        Map<String, List<String>> testMap = new HashMap<>();
//
//
//        List<String> someList = new ArrayList<>();
//        //adds here
//
//        testMap.put("Some String", someList);
//
//
//        for (int i = 0; i < someList.size(); i++) {
//            System.out.println(someList.get(i));
//        }
//
//
//        Map<String, List<String>> groupNames = groupByFirstTwoLetters(allNames);
//        System.out.println(groupNames);
//
//        Map<String, List<String>> groupNames1 = groupByFirstNLetters(allNames, 3);
//        System.out.println(groupNames1);
//
//    }
//
//    //input: ["Bob", "Bobby", "Robert", "Roberto", "Alice", "Alica" ]
//    //output:
//    // Map with 3 keys:
//    // "Bo" -> List {"Bob", "Bobby"}
//    // "Ro" -> List: {"Robert", "Roberto"}
//    // "Al" -> List: {"Alice" , "Alica"}
//
//    public static Map<String, List<String>> groupByFirstTwoLetters(String[] toGroup) {
//
//        Map<String, List<String>> groups = new HashMap<>();
//        for (String toPlace : toGroup) {
//
//            //for substring() the end index is itself not included
//            String key = toPlace.length() < 3  ? toPlace:toPlace.substring(0, 2);
//
//            if (!groups.containsKey(key)) {
//                groups.put(key, new ArrayList<>());
//            }
//            groups.get(key).add(toPlace);
//        }
//        return groups;
//    }
//
//
//
//    public static Map<String, List<String>> groupByFirstNLetters(String[] toGroup, int numLetters) {
//
//        Map<String, List<String>> groups = new HashMap<>();
//        for (String toPlace : toGroup) {
//
//            //for substring() the end index is itself not included
//            String key = toPlace.length() < (numLetters + 1)  ? toPlace:toPlace.substring(0, numLetters);
//
//            if (!groups.containsKey(key)) {
//                groups.put(key, new ArrayList<>());
//            }
//            groups.get(key).add(toPlace);
//        }
//        return groups;
//    }
//}

//End

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