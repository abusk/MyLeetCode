class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++) {
            if(i == 0) {
                List<Integer> firstList = new ArrayList<>();
                firstList.add(1);
                ans.add(firstList);
            } else {
                List<Integer> pList = ans.get(i-1);
                List<Integer> nList = new ArrayList<>();
                nList.add(pList.get(0));
                for(int j = 1; j<pList.size(); j++) {
                    int next = pList.get(j-1) + pList.get(j);
                    nList.add(next);
                }
                nList.add(pList.get(pList.size()-1));
                ans.add(nList);
            }
        }
        return ans;
    }
}