package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LeetCode 210 - Course Schedule II
Difficulty: Medium
Link: https://leetcode.com/problems/course-schedule-ii/

Approach (Topological Sort - Kahn’s Algorithm / BFS):
- Treat each course as a node in a directed graph, and each prerequisite pair [a, b] as an edge b → a.
- Build an adjacency list to represent dependencies and compute the indegree (number of prerequisites) for each course.
- Initialize a queue with all courses having indegree 0 (no prerequisites).
- Repeatedly remove courses from the queue, add them to the result order, and reduce the indegree of their dependent courses.
- If a dependent course’s indegree becomes 0, add it to the queue.
- If all courses are processed, return the topological order; otherwise, return an empty array (cycle detected).

Complexity:
- Time Complexity: O(V + E)
  (V = numCourses, E = number of prerequisite pairs)
- Space Complexity: O(V + E)
  for adjacency list, indegree array, and queue.
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        // Courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        // BFS
        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            order[index++] = course;

            for(int neighbor : adj.get(course)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0) queue.add(neighbor);
            }
        }

        if (index == numCourses) return order;
        
        return new int[0];
    }

}
