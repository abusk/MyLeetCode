class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> (b+ a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        return String.join("", arr);
    }
}