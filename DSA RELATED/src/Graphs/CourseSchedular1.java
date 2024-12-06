package Graphs;
import java.util.*;
import java.util.*;

public class CourseSchedular1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list for prerequisites
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Calculate indegree for each course
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Initialize queue with courses that have no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Perform topological sort
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        // Check if topological sort includes all courses
        return topo.size() == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedular1 scheduler = new CourseSchedular1();

        // Example 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        boolean result1 = scheduler.canFinish(numCourses1, prerequisites1);
        System.out.println("Can finish all courses (Example 1): " + result1);

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}}; // Cycle example
        boolean result2 = scheduler.canFinish(numCourses2, prerequisites2);
        System.out.println("Can finish all courses (Example 2): " + result2);
    }
}
