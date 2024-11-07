// class Node {
//     String tokenId;
//     int ttl;
//     public Node(String tokenId, int ttl) {
//         this.tokenId = tokenId;
//         this.ttl = ttl;
//     }
// }
// class AuthenticationManager {
//     Map<String, Node> map;
//     Queue<Node> tokenQueue;
//     int ttl;
//     public AuthenticationManager(int timeToLive) {
//         this.ttl = timeToLive;
//         this.map = new HashMap<>();
//         this.tokenQueue = new ArrayDeque<>();
//     }
    
//     public void generate(String tokenId, int currentTime) {

//     }
    
//     public void renew(String tokenId, int currentTime) {
//         clearTokens(currentTime);
//         if(map.containsKey(tokenId)) {

//         }
//     }
    
//     public int countUnexpiredTokens(int currentTime) {
//         clearTokens(currentTime);
//         return map.size();
//     }
//     public void clearTokens(int currentTime) {
//         while (!tokenQueue.isEmpty() && tokenQueue.peek().ttl <= currentTime) {
//             Node expired = tokenQueue.poll();
//             map.remove(expired.tokenId);
//         }
//     }
// }

class AuthenticationManager {
    Map<String, Node> tokenMap;
    Queue<Node> tokenQueue;
    int ttl;
    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        tokenQueue = new ArrayDeque<>();
        tokenMap = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        Node node = new Node(tokenId, currentTime+ttl);
        tokenQueue.offer(node);
        tokenMap.put(tokenId, node);
    }
    
    public void renew(String tokenId, int currentTime) {
        clearTokens(currentTime);
        if(!tokenMap.containsKey(tokenId))
            return;
        tokenMap.get(tokenId).inUse = false;
        generate(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        clearTokens(currentTime);
        return tokenMap.size();
    }
    private void clearTokens(int time){
        while(!tokenQueue.isEmpty() && (tokenQueue.peek().expirationTime <= time || !tokenQueue.peek().inUse)){
            Node n = tokenQueue.poll();
            if(tokenMap.get(n.tokenId) == n)
                tokenMap.remove(n.tokenId);
        }
    }
}
class Node {
    String tokenId;
    int expirationTime;
    boolean inUse;
    public Node(String tId, int expiration){
        tokenId = tId;
        expirationTime = expiration;
        inUse = true;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */