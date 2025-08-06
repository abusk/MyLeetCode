// import java.util.*;
// class Solution {
//     public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//         int n = fruits.length;
//         TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//         int j = 0;
//         int c = 0;
//         for(int i = 0; i<n; i++) {
//             int f = fruits[i];
//             while (map.ceilingKey(f) == null && j < n) {
//                 int bs = baskets[j];
//                 List<Integer> idxs = map.getOrDefault(bs, new ArrayList<>());
//                 idxs.add(j);
//                 map.put(bs, idxs);
//                 j++;
//             }
//             SortedMap<Integer, List<Integer>> tailMap = map.tailMap(f);
//             List<Integer> lst = tailMap.values()
//                     .stream()
//                     .flatMap(List::stream)
//                     .toList();
//             Optional<Integer> ith = lst.stream().min((a, b) -> a-b);
//             if (ith.isPresent()) {
//                 c++;
//                 int key = baskets[ith.get()];
//                 List<Integer> idxs = map.get(key);
//                 if (idxs.size() > 1) {
//                     idxs.remove(ith.get());
//                     map.put(key, idxs);
//                 } else {
//                     map.remove(key);
//                 }
//             }
//         }
//         return n - c;
//     }
// }

class Solution {

    private int[] segTree = new int[400007];
    private int[] baskets;

    private void build(int p, int l, int r) {
        if (l == r) {
            segTree[p] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid);
        build((p << 1) | 1, mid + 1, r);
        segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
    }

    private int query(int p, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return Integer.MIN_VALUE;
        }
        if (ql <= l && r <= qr) {
            return segTree[p];
        }
        int mid = (l + r) >> 1;
        return Math.max(
            query(p << 1, l, mid, ql, qr),
            query((p << 1) | 1, mid + 1, r, ql, qr)
        );
    }

    private void update(int p, int l, int r, int pos, int val) {
        if (l == r) {
            segTree[p] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            update(p << 1, l, mid, pos, val);
        } else {
            update((p << 1) | 1, mid + 1, r, pos, val);
        }
        segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.baskets = baskets;
        int m = baskets.length;
        int count = 0;
        if (m == 0) {
            return fruits.length;
        }
        Arrays.fill(segTree, Integer.MIN_VALUE);
        build(1, 0, m - 1);
        for (int i = 0; i < fruits.length; i++) {
            int l = 0;
            int r = m - 1;
            int res = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (query(1, 0, m - 1, 0, mid) >= fruits[i]) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (res != -1 && baskets[res] >= fruits[i]) {
                update(1, 0, m - 1, res, Integer.MIN_VALUE);
            } else {
                count++;
            }
        }
        return count;
    }
}