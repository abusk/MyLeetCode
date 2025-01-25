class DSU {
    int rep[];
    public DSU(int capacity) {
        rep = new int[capacity];
        for(int i = 0; i < capacity; i++) {
            rep[i] = i;
        }
    }
    public int find(int x) {
        if(rep[x] == x) {
            return x;
        }
        return rep[x] = find(rep[x]);
    }
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return;
        }
        rep[rootY] = rootX;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int acSetSize = accounts.size();
        DSU dsu = new DSU(acSetSize);
        Map<String, Integer> emailGroup = new HashMap<>();
        for(int i = 0; i<acSetSize; i++) {
            for(int j = 1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    dsu.union(i, emailGroup.get(email));
                }             
            }
        }
        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int gropRep = dsu.find(group);
            List<String> comp = components.getOrDefault(gropRep, new ArrayList<>());
            comp.add(email);
            components.put(gropRep, comp);
        }
        List<List<String>> ans = new ArrayList<>();
        for(var entry : components.entrySet()) {
            int group = entry.getKey();
            String name = accounts.get(group).get(0);
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.addFirst(name);
            ans.add(emails);
        }
        return ans;
    }
}