class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<magazine.length(); i++){
            map.compute(magazine.charAt(i), (k, v)-> (v == null)? 1: v+1);
        }
        for(int i = 0; i<ransomNote.length(); i++){
            Integer v = map.get(ransomNote.charAt(i));
            if(v == null || v <= 0) {
                return false;
            }
            map.compute(ransomNote.charAt(i), (k, va) -> (va == null) ? null : va - 1);
        }
        return true;
    }
}