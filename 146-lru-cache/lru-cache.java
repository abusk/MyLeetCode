class Node {
    public Node next;
    public Node prev;
    public int key;
    public int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        if(this.map.containsKey(key)) {
            result = this.map.get(key).value;
            Node eNode = this.map.get(key);
            deleteNode(eNode);
            Node updateNode = new Node(key, result);
            addNode(updateNode);
            this.map.put(key, updateNode);
        }
        return result;
    }
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(Node updateNode) {
        updateNode.next = head.next;
        updateNode.prev = head;
        head.next.prev = updateNode;
        head.next = updateNode;
    }

    public void put(int key, int value) {
        Node updateNode = new Node(key, value);
        if (this.map.containsKey(key)) {
            Node eNode = this.map.get(key);
            deleteNode(eNode);
        } else {
            if(this.size == this.map.size()) {
                Node nodeToDelete = tail.prev;
                deleteNode(nodeToDelete);
                this.map.remove(nodeToDelete.key);
            }
        }
        addNode(updateNode);
        this.map.put(key, updateNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */