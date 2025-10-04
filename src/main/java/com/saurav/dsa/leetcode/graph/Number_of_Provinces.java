package src.main.java.com.saurav.dsa.leetcode.graph;

/*
LeetCode 547 - Number of Provinces
Difficulty: Medium
Link: https://leetcode.com/problems/number-of-provinces/

Problem:
You are given an `n x n` matrix isConnected where isConnected[i][j] = 1
if the ith city and the jth city are directly connected, and 0 otherwise.

A province is a group of directly or indirectly connected cities
and no other cities outside of the group.

Return the total number of provinces.

Approach:
- Use Depth First Search (DFS) to explore connected components in the graph.
- Iterate over each node (city). If it’s not visited, perform a DFS and mark all reachable nodes as visited.
- Increment province count for each DFS call.

Complexity:
- Time Complexity: O(n^2), since we may traverse the adjacency matrix fully.
- Space Complexity: O(n), for the visited array and recursion stack.
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }

        return count;
    }

    public void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && !visited[j]){
                dfs(j,isConnected,visited);
            }
        }
    }
}
