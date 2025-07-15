class Solution {
    public boolean isValid(String word) {
        if(word.length() <= 2) {
            return false;
        }
        List<Character> spl= Arrays.asList('@', '#', '$');
        List<Character> vo = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        int c = 0;
        int k =0;
        for(char a : word.toCharArray()) {
            if(spl.contains(a)) {
                return false;
            }
            if(Character.isLetter(a)) {
                if(vo.contains(a)) {
                    c++;
                } else {
                    k++;
                }
            }
        }
        if(c == 0 || k ==0) return false;
        return true;
    }
}