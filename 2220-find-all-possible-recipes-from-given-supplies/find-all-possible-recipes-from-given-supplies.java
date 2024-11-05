// class Solution {
//     public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//         Set<String> sup = new HashSet<>();
//         Map<String, List<String>> g = new HashMap<>();
//         for(String s: supplies) {
//             g.put(s, new ArrayList<>());
//             sup.add(s);
//         }
//         for(String r : recipes) {
//             g.put(r, new ArrayList<>());
//         }
//         for(int i = 0; i<recipes.length; i++) {
//             List<String> ings = ingredients.get(i);
//             for(String in : ings) {
//                 g.get(in).add(recipes[i]);
//             }
//         }
//         Map<String, Integer> indegree = new HashMap<>();
//         for(var ge : g.entrySet()) {
//             List<String> depens = ge.getValue();
//             String k = ge.getKey();
//             indegree.put(k, indegree.getOrDefault(k, -1)+1);
//             for(String d : depens) {
//                 indegree.put(d, indegree.getOrDefault(d, -1)+1);
//             }
//         }
//         return null;
//     }
// }

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>();
        HashMap<String, Integer> index = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        // create hashset of supplies
        for(String s: supplies) {
            sup.add(s);
        }
        
        // store index of all recipes
        for(int i = 0; i < recipes.length; i++) {
            index.put(recipes[i], i);
        }
        
        int[] indegree = new int[recipes.length];
        // create a mapping of all the recipes that are Ingredients as well
        // to the recipes they are ingredients for
        for(int i = 0; i < recipes.length; i++) {
            for(String need: ingredients.get(i)) {
                if(sup.contains(need))
                    continue;
                
                map.putIfAbsent(need, new ArrayList<String>());
                map.get(need).add(recipes[i]);
                indegree[i]++;
            }
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        // add all the recipes with indegree 0 to the queue
        for(int i = 0; i < recipes.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        List<String> cooked = new ArrayList<>();
        while(!q.isEmpty()) {
            int i = q.poll();
            cooked.add(recipes[i]);
            
            if(!map.containsKey(recipes[i])) {
                // if the map does not contain this recipe, this means
                // this recipe is not an ingredient for any other recipe
                // and no further processing is required
                continue;
            }
            
            for(String recipe: map.get(recipes[i])) {
                if(--indegree[index.get(recipe)] == 0) {
                    q.add(index.get(recipe));
                }
            }
        }
        
        return cooked;
    }
}