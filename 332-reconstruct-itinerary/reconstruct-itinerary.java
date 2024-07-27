// class Solution {
//     List<List<String>> anss = new ArrayList<>();

//     public List<String> findItinerary(List<List<String>> tickets) {
//         Set<String> st = new HashSet<>();
//         Map<String, List<String>> map = new HashMap<>();
//         for(List<String> t : tickets) {
//             st.add(t.get(0) + "-" + t.get(1));
//             List<String> lst = map.getOrDefault(t.get(0), new ArrayList<>());
//             lst.add(t.get(1));
//             map.put(t.get(0), lst);
//         }
//         for(String from : map.keySet()) {
//             dfs(map, new HashSet<>(st), from, new ArrayList<>());
//         }
//         System.out.println(anss);
//         return null;
//     }
//     public void dfs(Map<String, List<String>> map, Set<String> sst, String from, List<String> ans) {
//         if(sst.isEmpty()) {
//             anss.add(ans);
//             return;
//         }
//         ans.add(from);
//         var lst = map.get(from);
//         if(lst== null || lst.isEmpty()) {
//             return;
//         }
//         for(String to : lst) {
//             String aa = from + "-" + to;
//             if(sst.contains(aa)) {
//                 sst.remove(aa);
//             } else {
//                 return;
//             }
//             dfs(map, sst, to, ans);
//         }
//     }
// }

// 

class Solution {
  // origin -> list of destinations
  HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
  LinkedList<String> result = null;

  public List<String> findItinerary(List<List<String>> tickets) {
    // Step 1). build the graph first
    for(List<String> ticket : tickets) {
      String origin = ticket.get(0);
      String dest = ticket.get(1);
      if (this.flightMap.containsKey(origin)) {
        LinkedList<String> destList = this.flightMap.get(origin);
        destList.add(dest);
      } else {
        LinkedList<String> destList = new LinkedList<String>();
        destList.add(dest);
        this.flightMap.put(origin, destList);
      }
    }

    // Step 2). order the destinations
    this.flightMap.forEach((key, value) -> Collections.sort(value));

    this.result = new LinkedList<String>();
    // Step 3). post-order DFS
    this.DFS("JFK");
    return this.result;
  }

  protected void DFS(String origin) {
    // Visit all the outgoing edges first.
    if (this.flightMap.containsKey(origin)) {
      LinkedList<String> destList = this.flightMap.get(origin);
      while (!destList.isEmpty()) {
        // while we visit the edge, we trim it off from graph.
        String dest = destList.pollFirst();
        DFS(dest);
      }
    }
    // add the airport to the head of the itinerary
    this.result.offerFirst(origin);
  }
}

