import java.util.*;

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        int[][] meet = new int[n][2];
        int count = 1;
        for(int i = 0; i < n; i++) {
            meet[i][0] = start.get(i);
            meet[i][1] = end.get(i);
        }
        
        Arrays.sort(meet, newComp);
        int limit = meet[0][1];
        for(int i = 1; i < n; i++) {
            if(meet[i][0] >= limit) {
                limit = meet[i][1];
                count++;
            }
        }
        return count;
    }
}

//Time complexity = O(N + N*Log(N))
//Space complexity = O(N)
