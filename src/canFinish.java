import java.util.LinkedList;
import java.util.Queue;

public class canFinish {
    public static boolean mySolution(int numCourses, int[][] prerequisites) {
        // we see the course as vertices, if course i is prerequisite of course j, then there an edge from i to j.
        // (use matrix to represent graph and record the indegree of one vertice). Then we use topological sort,
        // first we put all the vertices that has 0 indegree, delete the related edges, then try to find vertices that
        // has 0 indegree. At last, if we can delete all the vertices, it's possible to finish all courses.

        int[][] graph = new int[numCourses][numCourses]; // indicate the graph
        int[] indegree = new int[numCourses]; // indicate the indegree of course[i]

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];

            // record the indegree
            if (graph[preCourse][course] == 0) {
                indegree[course] += 1;
            }
            graph[preCourse][course] = 1; // record the edge
        }

        int count = 0; // record the number of vertices with indegree = 0
        Queue<Integer> queue = new LinkedList<>();

        // put all the vertices with indegree = 0 into the queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count += 1;
            // delete related edges
            for (int i = 0; i < numCourses; i++) {
                if (graph[course][i] != 0) {
                    indegree[i] -= 1;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0}, {0,1}};
        System.out.println(mySolution(2, nums));
    }
}
