// class TrieNode {
//     TrieNode[] nodes;
//     boolean isEnd;
//     public TrieNode() {
//         this.nodes = new TrieNode[128];
//     }
//     public void addChar(char ch, boolean isEnd) {
//         if(nodes[ch] == null) {
//             nodes[ch] = new TrieNode();
//             nodes[ch].isEnd = isEnd;
//         }
//     }
// }
// class AutocompleteSystem {
//     TrieNode root;
//     Map<String, Integer> rankMap;
//     String inputString;
//     List<int[]> sortedRank = new ArrayList<>();
//     public AutocompleteSystem(String[] sentences, int[] times) {
//         rankMap = new HashMap<>();
//         for(int i = 0; i<sentences.length; i++) {
//             rankMap.put(sentences[i], times[i]);
//         }
//         root = new TrieNode();
//         for(String sent : sentences) {
//             addInTrie(sent);
//         }
//         inputString = "";
//     }
//     public void addInTrie(String word) {
//         TrieNode node = root;
//         for(int i = 0; i<word.length(); i++) {
//             char c = word.charAt(i);
//             if(i == word.length()-1) {
//                 node.addChar(c, true);
//             } else {
//                 node.addChar(c, false);
//             }
//             node = node.nodes[c];
//         }

//     }
//     public void dfs(TrieNode node, StringBuilder sb, List<String> foundString) {
//         if(node == null || node.isEnd) {
//             if(!sb.isEmpty()) {
//                 foundString.add(sb.toString());
//             }
//             return;
//         }
//         for(int i = 0; i<128; i++) {
//             if(node.nodes[i] != null) {
//                 sb.append((char)i);
//                 dfs(node.nodes[i], sb, foundString);
//                 sb.delete(sb.length()-1, sb.length());
//             }
//         }
//     }
//     public List<String> input(char c) {
//         List<String> ans = new ArrayList<>();
//         if(c == '#') {
//             inputString = "";
//             return ans;
//         }
//         List<String> foundSentences = new ArrayList<>();
//         inputString = inputString + "" + c;
//         TrieNode node = root;
//         for(int i = 0; i<inputString.length(); i++) {
//             node = node.nodes[inputString.charAt(i)];
//         }
//         dfs(node, new StringBuilder(), foundSentences);
//         for(int i = 0; i<foundSentences.size(); i++) {
//             foundSentences.set(i, inputString+foundSentences.get(i));
//         }
//         List<String[]> sortedByRank = new ArrayList<>();
//         for(String f : foundSentences) {
//             int rank = rankMap.get(f);
//             sortedByRank.add(new String[]{f, rank+""});
//         }
//         sortedByRank.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
//         for(int i = 0; i < Math.min(3, sortedByRank.size()); i++) {
//             ans.add(sortedByRank.get(i)[0]);
//         }
//         return ans;
//     }
// }

// /**
//  * Your AutocompleteSystem object will be instantiated and called as such:
//  * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
//  * List<String> param_1 = obj.input(c);
//  */

class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> sentences;
    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

class AutocompleteSystem {
    TrieNode root;
    TrieNode currNode;
    TrieNode dead;
    StringBuilder currSentence;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
        
        currSentence = new StringBuilder();
        currNode = root;
        dead = new TrieNode();
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<String>();
        }
        
        currSentence.append(c);
        if (!currNode.children.containsKey(c)) {
            currNode = dead;
            return new ArrayList<String>();
        }
        
        currNode = currNode.children.get(c);
        List<String> sentences = new ArrayList<>(currNode.sentences.keySet());
        Collections.sort(sentences, (a, b) -> {
            int hotA = currNode.sentences.get(a);
            int hotB = currNode.sentences.get(b);
            if (hotA == hotB) {
                return a.compareTo(b);
            }
            
            return hotB - hotA;
        });
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sentences.size()); i++) {
            ans.add(sentences.get(i));
        }
        
        return ans;
    }
    
    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for (char c: sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
        }
    }
}