class SegmentTree {
    private int [] tree;
    private int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        int len = arr.length;
        this.tree = new int[4 * len];
        build(0, 0, len-1);
    }

    public void build(int i, int l, int r) {
        if(l == r) {
            tree[i] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        build(leftI, l, mid);
        build(rightI, mid+1, r);
        tree[i] = Math.max(tree[leftI], tree[rightI]);
    }

    public void update(int i, int pos, int val, int l, int r) {
        if(l == r) {
            tree[i] = val;
            return;
        }
        int mid = (l + r) /2;
        int leftI = 2 * i + 1;
        int rightI = 2 * i + 2;
        if(mid >= pos) {
            update(leftI, pos, val, l, mid);
        } else {
            update(rightI, pos, val, mid+1, r);
        }
        tree[i] = Math.max(tree[leftI], tree[rightI]);
    }

    public int findFirst(int i, int l, int r, int need) {
        if(tree[i] < need) {
            return -1;
        }
        if(l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;
        if(tree[li] >= need) {
            return findFirst(li, l, mid, need);
        }
        return findFirst(ri, mid+1, r, need);
    }
}
class Solution {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int len = baskets.length;
        SegmentTree segmentTree = new SegmentTree(baskets);
        int ans = 0;
        for(int f : fruits) {
            int pos = segmentTree.findFirst(0, 0, len-1, f);
            if(pos == -1) {
                ans++;
            } else {
                segmentTree.update(0, pos, 0, 0, len-1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] f = {4,2,5};
        int [] b = {3,5,4};
        System.out.println(numOfUnplacedFruits(f, b));
    }
}