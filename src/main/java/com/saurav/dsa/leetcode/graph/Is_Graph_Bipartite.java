package src.main.java.com.saurav.dsa.leetcode.graph;

/*
LeetCode 785 - Is Graph Bipartite?
Difficulty: Medium
Link: https://leetcode.com/problems/is-graph-bipartite/

Approach:
- The graph can be represented as an adjacency list where graph[i] contains all neighbors of node i.
- A graph is bipartite if it can be colored using two colors such that no two adjacent nodes share the same color.
- Use Depth-First Search (DFS) to try coloring each connected component.
  - If a node is uncolored (-1), assign a color (0 or 1).
  - Recursively color all its neighbors with the opposite color (1 - currentColor).
  - If any neighbor already has the same color as the current node, the graph is not bipartite.
- Because the graph may be disconnected, iterate through all nodes and start DFS for each unvisited component.

Key Detail:
- Do NOT pre-color any node (e.g., node 0), since the graph may not be connected.
  Each unvisited node should start DFS fresh with an initial color.

Complexity:
- Time Complexity: O(V + E)
  (Each vertex and edge is processed once during DFS)
- Space Complexity: O(V)
  (For the recursion stack and color array)

*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        
        for(int i=0;i<graph.length;i++){
            if(visited[i]==-1){
                if(!dfs(i,graph,visited,0)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int[][] adj, int[] visited, int color){

        visited[node] = color;

        for(int neighbor : adj[node]){
            if(visited[neighbor]==-1){
                if(!dfs(neighbor, adj, visited, 1-color)){
                    return false;
                }
            } else if(visited[neighbor]==color){
                return false;
            }
        }

        return true;
    }
}
