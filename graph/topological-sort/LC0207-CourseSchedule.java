/**
 * LeetCode #207 - Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * Pattern: Graph + Topological Sort (BFS - Kahn's Algorithm)
 *
 * 🧠 Core Insight
 * This is a cycle detection problem in a directed graph.
 * If a cycle exists → impossible to finish all courses.
 * If no cycle → possible.
 *
 * ⏱ Time Complexity: O(V + E)
 * 💾 Space Complexity: O(V + E)
 *
 * 🔥 Pattern Recognition Signal
 * If problem says:
 * - prerequisite
 * - dependency
 *
 * → Think: Topological Sort
 */

import java.util.*;

public class LC0207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2: Add all indegree 0 nodes
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;

        // Step 3: BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processed++;

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == numCourses;
    }
}
