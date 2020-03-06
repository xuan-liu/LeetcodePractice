import java.util.*;

public class findLadders {
    public static List<List<String>> mySolution(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        HashMap<String, List<String>> nodeNeighbors = new HashMap<>(); // store neighbors for every node
        HashMap<String, Integer> distance = new HashMap<>(); // store Distance of every node from the start node

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        System.out.println(nodeNeighbors);
        System.out.println(distance);

        List<List<String>> res = new ArrayList<>();
        ArrayList<String> solution = new ArrayList<>();
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    /* DFS: output all paths with the shortest distance */
    private static void dfs(String cur, String end, Set<String> dict, HashMap<String, List<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        // base case: if end = cur, then add the solution to res
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next: nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private static void bfs(String begin, String end, Set<String> dict, HashMap<String, List<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String s: dict) {
            nodeNeighbors.put(s, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        distance.put(begin, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor: neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    // check if visited
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(cur) + 1);

                        // check if we found the end
                        if (end.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    /* Find all next level nodes */
    private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();

        // replace chs[i] with ch (a to z)
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(mySolution("hit", "cog",dict));
    }

}
