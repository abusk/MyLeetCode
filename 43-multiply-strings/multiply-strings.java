class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<List<Integer>> lst = new ArrayList<>();
        int l1 = num1.length();
        int l2 = num2.length();
        try {
            int lz = 0;
            for(int i = l1-1; i>=0; i--) {
                int a = Integer.parseInt(num1.substring(i, i+1));
                int carry = 0;
                List<Integer> inter = new ArrayList<>();
                for(int j = l2-1; j>=0; j--) {
                    int b = Integer.parseInt(num2.substring(j, j+1));
                    int mr = a * b + carry;
                    inter.add(mr % 10);
                    carry = mr / 10;
                }
                inter.add(carry);
                for(int k = 0; k<(l1 -1)-lz; k++) {
                    inter.add(0);
                }
                Collections.reverse(inter);
                for(int k = 0; k <lz; k++) {
                    inter.add(0);
                }
                lz++;
                lst.add(inter);
            }
        } catch(Exception e) {}
        
        String ans = "";
        int carry = 0;
        for(int j = l2 +l1 - 1; j >= 0; j--) {
            int sum = 0;
            for(int i = 0; i < lst.size(); i++) {
                sum += lst.get(i).get(j);
            }
            sum += carry;
            ans = sum % 10 + ans;
            carry = sum /10;
        }
        ans = carry + ans;
        int i = 0;
        while(ans.charAt(i) == '0') {
            i++;
        }
        return ans.substring(i);
    }
}