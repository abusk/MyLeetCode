class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[arr.length];
        q.add(start);
        while(!q.isEmpty()) {
            int qlen = q.size();
            for(int i =0; i<qlen; i++) {
                int poll = q.poll();
                vis[poll] = true;
                if(arr[poll] == 0) {
                    return true;
                } else {
                    int prv = poll - arr[poll];
                    int nxt = poll + arr[poll];
                    if(prv >= 0 && !vis[prv]) {
                        q.add(prv);
                    }
                    if(nxt < arr.length && !vis[nxt]) {
                        q.add(nxt);
                    }
                }
            }
        }
        return false;
    }
}