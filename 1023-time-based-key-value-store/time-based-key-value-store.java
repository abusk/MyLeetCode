class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> timeV = new TreeMap<>();
            timeV.put(timestamp, value);
            map.put(key, timeV);
        }
    }
    
    public String get(String key, int timestamp) {
        var timeV = map.get(key);
        if(timeV == null) {
            return "";
        }
        String res = timeV.get(timestamp);
        if(res == null) {
            var floorEntry = timeV.floorEntry(timestamp);
            if(floorEntry != null) {
                return floorEntry.getValue();
            }
        }
        return res == null ? "" : res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */