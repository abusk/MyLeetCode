// class Solution {
//     public static int scheduleCourse(int[][] courses) {
//         Arrays.sort(courses, (a,b) -> a[1] - b[1]);
//         int len = courses.length;
//         int maxT = courses[len-1][1];
//         Integer[][] memo = new Integer[len+1][maxT +1];
//         return dp(courses, 0, 0, memo);
//     }

//     public static int dp(int[][] lst, int i, int fday, Integer[][] memo) {
//         if(i >= lst.length) {
//             return 0;
//         }
//         if(memo[i][fday] != null) {
//             return memo[i][fday];
//         }
//         int[] item = lst[i];
//         int notTake = dp(lst, i+1, fday, memo);
//         int take = 0;
//         if(fday + item[0] <= item[1]) {
//             take = dp(lst, i+1, fday + item[0], memo) +1;
//         }
//         int res = Math.max(take, notTake);
//         memo[i][fday] = res;
//         return res;
//     }
//     public static void main(String[] args) {
//         int[][] cour = {{100,200},{200,1300},{1000,1250},{2000,3200}};
//         System.out.println(scheduleCourse(cour));
//     }
    
// }

public class Solution {
    public int scheduleCourse(int[][] courses) {
        System.out.println(courses.length);
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] = -1;
            }
        }
        return count;
    }
}