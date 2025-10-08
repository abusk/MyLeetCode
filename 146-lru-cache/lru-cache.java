class Node {
    Node next;
    Node prev;
    int key;
    int val;
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}
class LRUCache {
    Node head;
    Node tail;
    int size;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node eNode = map.get(key);
        int val = eNode.val;
        removeNode(eNode);
        Node newNode = new Node(key, val);
        addInHead(newNode);
        map.put(key, newNode);
        return val;
    }
    
    public void put(int key, int value) {
        Node nodeToUpdate = new Node(key, value);
        if(map.containsKey(key)) {
            Node eNode = map.get(key);
            removeNode(eNode);
        } else {
            if(size == map.size()) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                map.remove(tailNode.key);
            }
        }
        addInHead(nodeToUpdate);
        map.put(key, nodeToUpdate);
    }
    public void addInHead(Node newHead) {
        newHead.next = head.next;
        head.next.prev = newHead;
        newHead.prev = head;
        head.next = newHead;
    }
    public void removeNode(Node nodeToRemove) {
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */