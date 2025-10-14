package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/*
LeetCode 802 - Find Eventual Safe States
Difficulty: Medium
Link: https://leetcode.com/problems/find-eventual-safe-states/

Approach (DFS + Coloring):
- Use a 3-state coloring system to track node states:
    0 = Unvisited, 1 = Visiting (in recursion), 2 = Safe.
- Perform DFS for each unvisited node:
    - If any neighbor leads to a cycle (color = 1), mark current node unsafe.
    - If all neighbors are safe, mark the current node as safe (color = 2).
- After processing all nodes, return all nodes marked safe.

Complexity:
- Time Complexity: O(V + E)
  (Each node and edge is visited once.)
- Space Complexity: O(V)
  (For recursion stack and color array.)
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len]; // 0 = Unvisited, 1 = Visited, 2 = Safe
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<len;i++){
            if(dfs(i,graph,color)){
                result.add(i);
            }
        }

        return result;
    }

    public boolean dfs(int node, int[][] graph, int[] color){
        if(color[node]!=0){
            return color[node] == 2;
        }

        color[node] = 1;

        for(int neighbor : graph[node]){
            if(color[neighbor]==1 || !(dfs(neighbor,graph,color))){
                return false;
            }
        }

        color[node] = 2;

        return true;
    }
}
