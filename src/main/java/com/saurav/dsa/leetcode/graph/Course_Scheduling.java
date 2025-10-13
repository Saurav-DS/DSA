package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LeetCode 207 - Course Schedule
Difficulty: Medium
Link: https://leetcode.com/problems/course-schedule/

Approach (Topological Sort - Kahn’s Algorithm / BFS):
- Model courses as nodes in a directed graph, where each prerequisite pair [a, b] represents an edge b → a.
- Build an adjacency list to store course dependencies and maintain an indegree array to track how many prerequisites each course has.
- Add all courses with indegree 0 (no prerequisites) to a queue.
- Perform BFS:
  - Remove a course from the queue and increment the count of completed courses.
  - Decrease the indegree of all dependent courses by 1.
  - If any course’s indegree becomes 0, add it to the queue.
- If the total number of processed courses equals numCourses, return true (no cycle, all courses can be completed); otherwise, return false (cycle detected).

Complexity:
- Time Complexity: O(V + E)
  (V = numCourses, E = number of prerequisite pairs)
- Space Complexity: O(V + E)
  for adjacency list, indegree array, and queue.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            index++;

            for(int neighbor : adj.get(course)){
                indegree[neighbor]--;

                if(indegree[neighbor]==0) queue.add(neighbor);
            }
        }

        if(index==numCourses) return true;

        return false;
    }
}
