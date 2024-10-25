class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mPoints = new ArrayList<>();
        for(String s : timePoints) {
            mPoints.add(getMinutes(s));
        }
        mPoints.sort((a, b) -> a.compareTo(b));
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<mPoints.size(); i++) {
            min = Math.min(mPoints.get(i) - mPoints.get(i-1), min);
        }
        min = Math.min((1440 - mPoints.get(mPoints.size()-1)) + mPoints.get(0), min);
        return min;
    }
    private int getMinutes(String timePoint) {
        String [] split = timePoint.split("[:]");
        int hM = Integer.parseInt(split[0]) * 60;
        int tm = hM + Integer.parseInt(split[1]);
        return tm % 1440;
    }
}