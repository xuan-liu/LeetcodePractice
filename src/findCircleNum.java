public class findCircleNum {
    public static int mySolution(int[][] M) {
        // every person is a node, if M[i][j] == 1, then ith person and jth person have edge. use DFS to count connected part
        int count = 0;
        boolean[] visited = new boolean[M.length]; // visited[i] means whether ith person has been visited

        for (int i = 0; i < M.length; i++) {
            // if ith person is not visited, we dfs it, and add count
            if (visited[i] == false) {
                dfs(M, visited, i);
                count += 1;
            }
        }
        return count;
    }

    /* use DFS to iterate all ith person's direct or indirect friends */
    private static void dfs(int[][] M, boolean[] visited, int i) {
        // iterate through all other person except ith person
        for (int j = 0; j < M.length; j++) {

            // if the person is not visited, and he is the friend with ith person, dfs it
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};
        System.out.println(mySolution(nums));
    }

}
