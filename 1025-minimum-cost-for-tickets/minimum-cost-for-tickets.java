// class Solution {
//     Set<Integer> set;
//     int lastTravelDay;
//     int[] tcosts;
//     public int mincostTickets(int[] days, int[] costs) {
//         set = new HashSet<>();
//         for(int d : days) {
//             set.add(d);
//         }
//         lastTravelDay = days[days.length -1];
//         tcosts = costs;
//         return dp(1);
//     }
//     public int dp(int curDay) {
//         if(curDay > lastTravelDay) {
//             return 0;
//         }
//         if(!set.contains(curDay)) {
//             return dp(curDay +1);
//         }
//         int oneday = tcosts[0] + dp(curDay + 1);
//         int sevenDay = tcosts[1] + dp(curDay + 7);
//         int monthDay = tcosts[2] + dp(curDay + 30);
//         return Math.min(oneday, Math.min(sevenDay, monthDay));
//     }
// }

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int d : days) {
            set.add(d);
        }
        int lastTravelDay = days[days.length -1];

        int dp[] = new int[lastTravelDay +1];
        dp[0] = 0;
        for(int day = 1; day <= lastTravelDay; day++) {
            if(!set.contains(day)) {
                dp[day] = dp[day -1];
            } else {
                int od = costs[0] + dp[Math.max(0, day-1)];
                int sd = costs[1] + dp[Math.max(0, day-7)];
                int md = costs[2] + dp[Math.max(0, day-30)];
                dp[day] = Math.min(od, Math.min(sd, md));
            }
        }
        return dp[lastTravelDay];
    } 
}