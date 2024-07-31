// class Solution {
//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//         int n = startTime.length;
//         int [][] jobs = new int[startTime.length][3];
//         for(int i =0; i<startTime.length; i++) {
//             int[] j = new int[] {startTime[i], endTime[i], profit[i]};
//             jobs[i] = j;
//         }
//         Arrays.sort(jobs, (a, b)-> a[0] -b[0]);
//         int [] dp = new int[n];
//         dp[0] = jobs[0][2];
//         for(int i = 1; i<jobs.length; i++) {
//             int[] job = jobs[i];
//             int p = job[2];
//             int l = binarySearch(jobs, i);
//             if (l != -1) {
//                 p += dp[l];
//             }
//             dp[i] = Math.max(p, dp[i - 1]);
//         }
//         return dp[n-1];
//     }
//     public int binarySearch(int [][] jobs, int index) {
//         int low = 0, high = index - 1;
//         while (low <= high) {
//             int mid = (low + high) / 2;
//             if (jobs[mid][1] <= jobs[index][0]) {
//                 if (jobs[mid + 1][1] <= jobs[index][0]) {
//                     low = mid + 1;
//                 } else {
//                     return mid;
//                 }
//             } else {
//                 high = mid - 1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    // maximum number of jobs are 50000
    int memo[] = new int[50001];
    
    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime) {
        int length = startTime.length;
        
        for (int position = length - 1; position >= 0; position--) {
            // it is the profit made by scheduling the current job 
            int currProfit = 0;
            
            // nextIndex is the index of next non-conflicting job
            int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
            
            // if there is a non-conflicting job possible add it's profit
            // else just consider the curent job profit
            if (nextIndex != length) {
                currProfit = jobs.get(position).get(2) + memo[nextIndex];
            } else {
                currProfit = jobs.get(position).get(2);
            }
            
            // storing the maximum profit we can achieve by scheduling 
            // non - conflicting jobs from index position to the end of array
            if (position == length - 1) {
                memo[position] = currProfit;
            } else {
                memo[position] = Math.max(currProfit, memo[position + 1]);
            }
        }
        
        return memo[0];
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            
            jobs.add(currJob);
        }
        
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfit(jobs, startTime);
    }
}