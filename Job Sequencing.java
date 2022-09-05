class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int[] ans = new int[2];
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        
        int maxi = 0;
        for(int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i].deadline);
        }
        
        int result[] = new int[maxi + 1];
        Arrays.fill(result, -1);
        
        int countJobs = 0, maxProfit = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = arr[i].deadline; j > 0; j--) {
                if(result[j] == -1) {
                    result[j] = 1;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        ans[0] = countJobs;
        ans[1] = maxProfit;
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
