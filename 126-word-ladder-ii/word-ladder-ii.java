// class Solution {
//     public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>> ans = bfs(new HashSet<>(wordList), beginWord, endWord);
//         if(ans.isEmpty()) {
//             return ans;
//         }
//         ans.sort((a, b) -> a.size() - b.size());
//         int len = ans.get(0).size();
//         List<List<String>> res = new ArrayList<>();
//         for(var b : ans) {
//             if(b.size() == len) {
//                 res.add(b);
//             } else {
//                 break;
//             }
//         }
//         return res;
//     }
//     public static List<List<String>> bfs(Set<String> wordList, String cur, String endWord) {
//         List<List<String>> ans = new ArrayList<>();
//         Queue<List<String>> queue = new LinkedList<>();
//         queue.add(Arrays.asList(cur));
//         int min = Integer.MAX_VALUE;
//         while (!queue.isEmpty()) {
//             List<String> nextList = queue.poll();
//             String next = nextList.getLast();
//             if(next.equals(endWord)) {
//                 min = nextList.size();
//                 ans.add(nextList);
//                 continue;
//             }
//             for(int i = 0; i<next.length(); i++) {
//                 StringBuilder sb = new StringBuilder(next);
//                 for(int l = 0; l<26; l++) {
//                     char nch = (char) ((int) 'a' + l);
//                     sb.setCharAt(i, nch);
//                     String gen = sb.toString();
//                     if(!gen.equals(next) && wordList.contains(gen) && !nextList.contains(gen)) {
//                        List<String> newList = new ArrayList<>(nextList);
//                        newList.add(gen);
//                        if(newList.size() <= min) {
//                            queue.add(newList);
//                        }
//                     }
//                 }
//             }
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//         List<List<String>> ans = findLadders("hit", "cog", wordList);
//         System.out.println("");
//     }

// }

class Solution {
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();
    List<String> currPath = new ArrayList<String>();
    List<List<String>> shortestPaths = new ArrayList<List<String>>();

    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<String>();
        char charList[] = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];

            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;

                // skip if the character is same as original or if the word is not present in the wordList
                if (
                    c == oldChar || !wordList.contains(String.valueOf(charList))
                ) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }

    private void backtrack(String source, String destination) {
        // store the path if we reached the endWord
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<String>(currPath);
            Collections.reverse(tempPath);
            shortestPaths.add(tempPath);
        }

        if (!adjList.containsKey(source)) {
            return;
        }

        for (int i = 0; i < adjList.get(source).size(); i++) {
            currPath.add(adjList.get(source).get(i));
            backtrack(adjList.get(source).get(i), destination);
            currPath.remove(currPath.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // remove the root word which is the first layer in the BFS
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        Map<String, Integer> isEnqueued = new HashMap<String, Integer>();
        isEnqueued.put(beginWord, 1);

        while (q.size() > 0) {
            // visited will store the words of current layer
            List<String> visited = new ArrayList<String>();

            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.peek();
                q.remove();

                // findNeighbors will have the adjacent words of the currWord
                List<String> neighbors = findNeighbors(currWord, wordList);
                for (String word : neighbors) {
                    visited.add(word);

                    if (!adjList.containsKey(word)) {
                        adjList.put(word, new ArrayList<String>());
                    }

                    // add the edge from word to currWord in the list
                    adjList.get(word).add(currWord);
                    if (!isEnqueued.containsKey(word)) {
                        q.add(word);
                        isEnqueued.put(word, 1);
                    }
                }
            }
            // removing the words of the previous layer
            for (int i = 0; i < visited.size(); i++) {
                if (wordList.contains(visited.get(i))) {
                    wordList.remove(visited.get(i));
                }
            }
        }
    }

    public List<List<String>> findLadders(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        // copying the words into the set for efficient deletion in BFS
        Set<String> copiedWordList = new HashSet<>(wordList);
        // build the DAG using BFS
        bfs(beginWord, endWord, copiedWordList);

        // every path will start from the endWord
        currPath.add(endWord);
        // traverse the DAG to find all the paths between endWord and beginWord
        backtrack(endWord, beginWord);

        return shortestPaths;
    }
}