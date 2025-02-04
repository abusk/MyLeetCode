class Solution {
    public boolean canSortArray(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        int count = -1;
        for(int i = 0; i<nums.length; i++) {
            int newCount = countBits(nums[i]);
            if(count != newCount) {
                sets.add(new ArrayList<>());
                count = newCount;
            }
            sets.getLast().add(nums[i]);
        }
        List<Integer> ss = new ArrayList<>();
        for(List<Integer> lst : sets) {
            lst.sort((a, b) -> a -b);
            ss.addAll(lst);
        }
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != ss.get(i)) {
                return false;
            }
        }
        return true;
    }
    private int countBits(int num) {
        int count = 0;
        while(num > 0) {
            
            if((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}