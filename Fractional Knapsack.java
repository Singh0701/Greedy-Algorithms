//Approach 1: Using TreeMap Data structure.

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        double maxProfit = 0; 
        TreeMap<Double, Double> itemsRatio = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            double ratio = (double) arr[i].value / (double) arr[i].weight;
            itemsRatio.put(ratio, itemsRatio.getOrDefault(ratio, 0.0) + (double)arr[i].weight);
        }
        
        for(double ratio: itemsRatio.keySet()) {
            double profit = ratio * itemsRatio.get(ratio);
            double weight = itemsRatio.get(ratio);
            if(weight <= W) {
                maxProfit += profit; 
                W = W - (int)weight;
            } else {
                maxProfit += ratio * W;
                W = W - W;
            }
        }
        return maxProfit;
    }
}

//Time complexity = O(N) + O(N * log(N));
//Space complexity = O(N)


//Without using a TreeMap, Space Optimized.

class Solution
{
    class itemsComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            if(r1 < r2) return 1;
            else if(r2 < r1) return -1;
            return 0;
        }
    }
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        double maxProfit = 0; 
        itemsComparator newComparator = new itemsComparator();
        Arrays.sort(arr, newComparator);
        for(int i = 0; i < n; i++) {
            double profit = (double) arr[i].value;
            double weight = (double) arr[i].weight;
            double ratio = profit / weight;
            if(weight <= W) {
                maxProfit += profit; 
                W = W - (int)weight;
            } else {
                maxProfit += ratio * W;
                W = W - W;
            }
        }
        return maxProfit;
    }
}

//Time complexity = O(N) + O(N * log(N));
//Space complexity = O(1)

