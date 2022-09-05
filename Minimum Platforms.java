class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformsRequired = 1;
        int platformNeeded = 1;
        int i = 1, j = 0;
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platformNeeded++;
                i++;
            } else if(arr[i] > dep[j]) {
                platformNeeded--;
                j++;
            }
            platformsRequired = Math.max(platformsRequired, platformNeeded);
        }
        return platformsRequired;
    }
    
}
