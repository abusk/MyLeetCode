class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        Set<String> res = new HashSet<>();
        List<Pair<String, Integer>> accMap = new ArrayList<>();
        for(List<String> at : access_times) {
            Pair<String, Integer> p = new Pair<>(at.get(0), getMinutes(at.get(1)));
            accMap.add(p);
        }
        accMap.sort((a, b) -> a.getValue() - b.getValue());
        for(Pair<String, Integer> at : accMap) {
            String name = at.getKey();
            int aTime = at.getValue();
            if(map.containsKey(name)) {
                List<Integer> tList = map.get(name);
                tList.add(aTime);
                if(tList.size() >= 3) {
                    int lastTime = tList.getLast();
                    int prv = tList.get(tList.size() - 3);
                    if(lastTime - prv < 60) {
                        res.add(name);
                    }
                }
                map.put(name, tList);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(aTime);
                map.put(name, lst);
            }
        }
        return new ArrayList<>(res);
    }
    public int getMinutes(String time) {
        String h = time.substring(0, 2);
        String m = time.substring(2);
        return Integer.parseInt(h) * 60 + Integer.parseInt(m);
    }
}