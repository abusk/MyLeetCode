class Trie {
    public Trie [] node = new Trie[10];
}

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie tr = build(arr1);
        int max = 0;
        for(int a : arr2) {
            int f = find(tr, a);
            max = Math.max(max, f);
        }
        return max;
    }
    public int find(Trie root, int num) {
        int c = 0;
        Trie current = root;
        String ss = String.valueOf(num);
        for(int i = 0; i<ss.length(); i++) {
            int d = Integer.parseInt(ss.substring(i, i+1));
            if(current.node[d] != null) {
                c++;
                current = current.node[d];
            } else {
                break;
            }
        }
        return c;
    }
    public Trie build(int[] arr1) {
        Trie root = new Trie();
        for(int a : arr1) {
            add(a, root);
        }
        return root;
    }

    public void add(int num, Trie node) {
        Trie current = node;
        String ss = String.valueOf(num);
        for(int i = 0; i<ss.length(); i++) {
            int d = Integer.parseInt(ss.substring(i, i+1));
            if(current.node[d] == null) {
                current.node[d] = new Trie();
            }
            current = current.node[d];
        }
    }
}