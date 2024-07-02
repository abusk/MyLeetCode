
// class AllOne {

//     private Map<String, Integer> map;
//     private Map<Integer, List<String>> freq;
//     private int max;
//     private int min;
//     public AllOne() {
//         map = new HashMap<>();
//         freq = new HashMap<>();
//         max = 0;
//         min = 0;
//     }
    
//     public void inc(String key) {
//         if (!map.containsKey(key)) {
//             map.put(key, 1);
//             List<String> st = freq.getOrDefault(1, new ArrayList<>());
//             st.add(key);
//             freq.put(1, st);
//             if(max == 0 && min == 0) {
//                 max = 1;
//             }
//             min = 1;
//         } else {
//             int cur = map.get(key);
//             List<String> st = freq.get(cur);
//             st.remove(key);
//             if(st.isEmpty()) {
//                 freq.remove(cur);
//                 if(cur == min) {
//                     min = cur+1;
//                 };
//                 if(cur == max) {
//                     max = cur +1;
//                 }
//             } else {
//                 freq.put(cur, st);
//                 max = Math.max(max, cur+1);
//             }
//             List<String> stt = freq.getOrDefault(cur+1, new ArrayList<>());
//             stt.add(key);
//             freq.put(cur+1, stt);
//         }
//     }
    
//     public void dec(String key) {
//         if (map.containsKey(key)) {
//             int cur = map.get(key);
//             List<String> st = freq.get(cur);
//             st.remove(key);
//             if(st.isEmpty()) {
//                 freq.remove(cur);
//                 if(cur == max) {
//                     if(cur == 1) {
//                         max = 0;
//                     } else {
//                         max = cur -1;
//                     }
//                 }
//                 if(cur == min) {
//                     if(cur == 1) {
//                         min = 0;
//                     } else {
//                         min = cur -1;
//                     }
//                 }
//             } else {
//                 freq.put(cur, st);
//             }
//             List<String> stt = freq.getOrDefault(cur-1, new ArrayList<>());
//             if(cur -1 == 1) {
//                 min = 1;
//             }
//             stt.add(key);
//             freq.put(cur-1, stt);
//         }
//     }
    
//     public String getMaxKey() {
//         if(max == 0) return "";
//         return freq.get(max).get(0);
//     }
    
//     public String getMinKey() {
//         if(min == 0) return "";
//         return freq.get(min).get(0);
//     }
// }

public class AllOne {
    private Map<String, Node> keyCountMap;
    private DoubleLinkedList countList;

    public AllOne() {
        keyCountMap = new HashMap<>();
        countList = new DoubleLinkedList();
    }

    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            Node node = keyCountMap.get(key);
            node.keys.remove(key);
            int newCount = node.count + 1;
            Node newNode = countList.addNodeAfter(node, newCount);
            newNode.keys.add(key);
            keyCountMap.put(key, newNode);
            if (node.keys.isEmpty()) {
                countList.removeNode(node);
            }
        } else {
            Node newNode = countList.addNodeAfter(countList.head, 1);
            newNode.keys.add(key);
            keyCountMap.put(key, newNode);
        }
    }

    public void dec(String key) {
        Node node = keyCountMap.get(key);
        node.keys.remove(key);
        if (node.count > 1) {
            int newCount = node.count - 1;
            Node newNode = countList.addNodeBefore(node, newCount);
            newNode.keys.add(key);
            keyCountMap.put(key, newNode);
        } else {
            keyCountMap.remove(key);
        }
        if (node.keys.isEmpty()) {
            countList.removeNode(node);
        }
    }

    public String getMaxKey() {
        return countList.tail.prev != countList.head ? countList.tail.prev.keys.iterator().next() : "";
    }

    public String getMinKey() {
        return countList.head.next != countList.tail ? countList.head.next.keys.iterator().next() : "";
    }

    private static class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private static class DoubleLinkedList {
        Node head, tail;

        DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        Node addNodeAfter(Node node, int count) {
            if (node.next.count == count) {
                return node.next;
            }
            Node newNode = new Node(count);
            newNode.next = node.next;
            newNode.prev = node;
            node.next.prev = newNode;
            node.next = newNode;
            return newNode;
        }

        Node addNodeBefore(Node node, int count) {
            if (node.prev.count == count) {
                return node.prev;
            }
            Node newNode = new Node(count);
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
            return newNode;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
