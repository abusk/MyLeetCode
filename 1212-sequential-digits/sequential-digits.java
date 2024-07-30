// class Solution {
//     int MAX_ALLOWD = 123456789;
//     public List<Integer> sequentialDigits(int low, int high) {
//         high = Math.min(high, MAX_ALLOWD);
//         List<Integer> ans = new ArrayList<>();
//         String l = String.valueOf(low);
//         List<Integer> next = new ArrayList<>();
//         adjust(next, l.length(), Integer.parseInt(l.substring(0, 1)));
//         int num = getNumber(next);
//         while(num < low) {
//             adjust(next, next.size(), next.get(0)+1);
//             num = getNumber(next);
//         }
//         if(num < high) {
//             ans.add(num);
//         }
//         while(num < high) {
//             adjust(next, next.size(), next.get(0)+1);
//             num = getNumber(next);
//             if(num <= high ) {
//                 ans.add(num);
//             }
//         }
//         ans.sort((a, b) -> a-b);
//         return ans;
//     }
//     public void adjust(List<Integer> next, int n, int start) {
//         next.clear();
//         next.add(start);
//         for(int i = 1; i<n; i++) {
//             int nd = next.get(i-1)+1;
//             if(nd<10) {
//                 next.add(nd);
//             } else {
//                 adjust(next, n+1, 1);
//             }
//         }
//     }
//     public int getNumber(List<Integer> next) {
//         int num = 0;
//         for(int i = 0; i<next.size(); i++) {
//             num = num*10 + next.get(i);
//         }
//         return num;
//     }
// }

class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    String sample = "123456789";
    int n = 10;
    List<Integer> nums = new ArrayList();

    int lowLen = String.valueOf(low).length();
    int highLen = String.valueOf(high).length();
    for (int length = lowLen; length < highLen + 1; ++length) {
      for (int start = 0; start < n - length; ++start) {
        int num = Integer.parseInt(sample.substring(start, start + length));
        if (num >= low && num <= high) nums.add(num);
      }
    }
    return nums;
  }
}