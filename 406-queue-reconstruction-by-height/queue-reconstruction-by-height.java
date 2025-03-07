class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]));
        List<int[]> output = new LinkedList<>();
        for(int[] p: people) {
            output.add(p[1], p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}