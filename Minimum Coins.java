public class Solution {
    public static int minimumCoins(int p){
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int count = 0;
        for(int i = 8; i >= 0; i--) {
            if(coins[i] <= p) {
                if(p % coins[i] == 0) {
                    count += (p/coins[i]);
                    p = 0; break;
                } else {
                    while(p >= coins[i]) {
                        p = p - coins[i];
                        count++;
                    }
                }
            }
        } return count;
    }
}


//Time complexity = O(N)
//Space complexity = O(1)
