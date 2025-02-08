class NumberContainers {
    Map<Integer, TreeSet<Integer>> mapTreeSet;
    Map<Integer, Integer> indexMap;
    public NumberContainers() {
        mapTreeSet = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexMap.containsKey(index)) {
            int existingNumber = indexMap.get(index);
            TreeSet<Integer> treeSet = mapTreeSet.get(existingNumber);
            treeSet.remove(index);
            if(treeSet.isEmpty()) {
                mapTreeSet.remove(existingNumber);
            }
        }
        indexMap.put(index, number);
        TreeSet<Integer> treeSet = mapTreeSet.getOrDefault(number, new TreeSet<>());
        treeSet.add(index);
        mapTreeSet.put(number, treeSet);
    }
    
    public int find(int number) {
        TreeSet<Integer> treeSet = mapTreeSet.getOrDefault(number, new TreeSet<>());
        if(treeSet.isEmpty()) {
            return -1;
        } else {
            return treeSet.getFirst();
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */