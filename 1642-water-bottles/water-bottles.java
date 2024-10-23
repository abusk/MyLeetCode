class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while(numBottles >= numExchange) {
            int regain =  numBottles / numExchange;
            count += regain;
            numBottles = regain + numBottles % numExchange;
        }
        return count;
    }
}