class Solution {
    public String fractionAddition(String expression) {
        List<Integer> denom = new ArrayList<>();
        List<Integer> nume = new ArrayList<>();
        for(int i = 0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '/') {
                int j = i+1;
                while(j <expression.length() && Character.isDigit(expression.charAt(j))) {
                    j++;
                }
                String denS = expression.substring(i+1, j);
                int den = Integer.parseInt(denS);
                denom.add(den);

                int k = i-1;
                while(k >=0 && Character.isDigit(expression.charAt(k))) {
                    k--;
                }
                if(k == -1) {
                    k = 0;
                }

                String numS = expression.substring(k, i);
                int num = Integer.parseInt(numS);
                nume.add(num);
            }
        }
        int ansDen = 1;
        for(Integer a : denom) {
            ansDen *= a;
        }
        int ansNum = 0;
        for(int i = 0; i<denom.size(); i++) {
            int d = ansDen / denom.get(i);
            ansNum += d * nume.get(i);
        }
        if(ansNum % ansDen == 0) {
            return (ansNum / ansDen) + "/" + 1;
        }
        int gcd = gcd(Math.abs(ansDen), Math.abs(ansNum));
        return (ansNum/gcd) + "/" + (ansDen/gcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}