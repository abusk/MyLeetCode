class SegmentTree {
    private int[] tree;
    private int[] original;
    public SegmentTree(int[] nums) {
        this.original = nums;
        int n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n-1);
    }
    private void build(int i, int l, int r) {
        if(l == r) {
            tree[i] = original[l];
            return;
        }
        int mid = (l + r) /2;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;
        build(li, l, mid);
        build(ri, mid +1, r);
        tree[i] = tree[li] + tree[ri];
    }

    public void update(int i, int pos, int val, int l, int r) {
        if(l == r) {
            tree[i] = val;
            return;
        }
        int mid = (l + r) / 2;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;
        if(mid >= pos) {
            update(li, pos, val, l, mid);
        } else {
            update(ri, pos, val, mid+1, r);
        }
        tree[i] = tree[li] + tree[ri];
    }

    public int query(int i, int l, int r, int ql, int qr) {
        if(qr < l || ql > r) {
            return 0;
        }
        if(l >= ql && r <= qr) {
            return tree[i];
        }
        int  mid = ( l + r) / 2;
        int li = 2 * i +1;
        int ri = 2 * i + 2;
        return query(li, l, mid, ql, qr) + query(ri, mid+1, r, ql, qr);
    }
}
class NumArray {
    SegmentTree segmentTree;
    int len = 0;
    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
        len = nums.length;
    }
    
    public void update(int index, int val) {
        segmentTree.update(0, index, val, 0, len -1);
    }
    
    public int sumRange(int left, int right) {
        return segmentTree.query(0, 0, len-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */