class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l1 = players.length;
        int l2 = trainers.length;
        int c = 0;
        int i = 0;
        int j = 0;
        while(i < l1 && j < l2) {
            if(players[i] <= trainers[j]) {
                c++;
                i++; j++;
            } else {
                j++;
            }
        }
        return c;
    }
}