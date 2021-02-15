public class FlowerBed {
    public static void main(String[] args) {

        int[] n = {0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(n, 4));
    }

    //https://leetcode.com/problems/can-place-flowers/submissions/
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int position = 0;
        if(n == 0)return true;
        while(position < flowerbed.length){
            if(flowerbed[position] == 0){
                if(position== flowerbed.length-1 || 0 == flowerbed[position + 1]){
                    n--; //found an spot
                }
                else {//adjacent plant afterwards so we move there
                    position++;
                }
            }
            if(n == 0) return true;
            position+=2;
        }
        return false;
    }

    //Eliot's version
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {

        int openSpots = 0;

        for(int i = 0; i < flowerbed.length && openSpots < n; i++){
            if(flowerbed[i] == 1){
                i++;
            }else if( (i == 0 || flowerbed[i-1] == 0)
                    && (i+1 == flowerbed.length || flowerbed[i+1] == 0)){
                i++;
                openSpots++;

            }
        }
        return openSpots >= n;
    }
}
