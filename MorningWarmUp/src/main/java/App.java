import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        long maxChainNum = -1;
        long maxChainLength = -1;

        Map<Long, Integer> memo = new HashMap<>();
        memo.put(1L, 0);
        for(long x = 1; x  < 1000000; x++ ){
         int currentChainLength = collatz(x, memo);
         if(currentChainLength > maxChainLength){
             maxChainLength = currentChainLength;
             maxChainNum = x;
         }
        }
        System.out.println(maxChainNum);
        System.out.println(maxChainLength);
    }

    private static int collatz(long x, Map<Long, Integer> memo) {
        int steps = 0;
        if (memo.containsKey(x)) {
            steps = memo.get(x);
        } else {
            long prior = -1;
            if (x % 2 == 0) {
                prior = x / 2;

            } else {
                prior = x * 3 + 1;
            }
            steps = 1 + collatz(prior, memo);
            memo.put(x, steps);
        }

        return steps;
    }


}
