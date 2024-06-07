class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (a, b)-> a.length() - b.length());
        String [] splits = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< splits.length; i++) {
            sb.append(changeWord(dictionary, splits[i]));
            if(i != splits.length-1) {
                sb.append(" ");
            }
            
        }
        return sb.toString();
    }
    public String changeWord(List<String> dictionary, String word) {
        for(String s : dictionary) {
            if(s.length() > word.length()) {
                continue;
            }
            boolean matched = true;
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) != word.charAt(i)) {
                    matched = false;
                }
            }
            if(matched) {
                return s;
            }
        }
        return word;
    }
}