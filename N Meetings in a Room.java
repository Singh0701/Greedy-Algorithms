import java.util.*;

public class Solution {
    static class meeting {
        int start;
        int end;
        int index;
        meeting(int s, int e, int i) {
            start = s;
            end = e;
            index = i;
        }
    }
    
    static class meetinComparator implements Comparator<meeting> {
        public int compare(meeting a, meeting b) {
            if(a.end < b.end) return -1;
            else if(a.end > b.end) return 1;
            else if(a.index < b.index) return -1;
            return 1;
        }    
    }
    
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        List<meeting> meet = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int n = start.length;
        for(int i = 0; i < n; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }
        meetinComparator mc = new meetinComparator();
        Collections.sort(meet, mc);
        answer.add(meet.get(0).index);
        int limit = meet.get(0).end;
        for(int i = 1; i < n; i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).index);
            }
        }
//         System.out.println(answer);
        return answer;
    }
}
