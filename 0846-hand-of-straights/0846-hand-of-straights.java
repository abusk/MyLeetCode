class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList();
        for(int i = 0; i<hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
            set.add(hand[i]);
        }
        Collections.sort(set);
        for(int a: set) {
            int gs = groupSize;
            boolean found = true;
            int key = a;
            while(gs > 0) {
                if(!map.containsKey(key)) {
                    found = false;
                    break;
                } else {
                    key--;
                    gs--;
                }
            }
            int gsn = groupSize;
            int keyn = a;
            if(found) {
                while(gsn > 0) {
                    int v = map.get(keyn);
                    if(v == 1) {
                        map.remove(keyn);
                    } else {
                        map.put(keyn, map.get(keyn)-1);
                    }
                    gsn--;
                    keyn--;
                }
            }
        }
        if(map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}