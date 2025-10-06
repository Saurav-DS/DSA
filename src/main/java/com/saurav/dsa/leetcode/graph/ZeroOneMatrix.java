package src.main.java.com.saurav.dsa.leetcode.graph;

/*
LeetCode 542 - 01 Matrix
Difficulty: Medium
Link: https://leetcode.com/problems/01-matrix/

Problem:
Given an m x n binary matrix mat, return a matrix where each cell contains 
the distance to the nearest 0. The distance between adjacent cells is 1.

Approach:
- Perform a Multi-Source Breadth-First Search (BFS).
- Initialize a queue with all cells containing 0 and mark them as visited.
- For each cell dequeued, explore its 4-directional neighbors (up, down, left, right).
- If a neighbor has not been visited, set its distance as current cell's distance + 1,
  mark it as visited, and enqueue it.
- Continue until all reachable cells are processed.

Complexity:
- Time Complexity: O(m * n), since each cell is visited once.
- Space Complexity: O(m * n), for the visited array and queue.

Notes:
- Uses a boolean visited matrix to ensure each cell is processed only once.
- Runtime may vary slightly (around 12–13 ms) depending on Java memory handling.
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int[] rows = {0,-1,1,0}; // left, top, down, right
        int[] cols = {-1,0,0,1};
        while(!queue.isEmpty()){
            int[] val = queue.poll();
            int row = val[0];
            int col = val[1];
            for(int i=0;i<4;i++){
                int r = row+rows[i];
                int c = col+cols[i];

                if(r>=0 && r<m && c>=0 && c<n && visited[r][c] == false){
                    result[r][c] = result[row][col]+1;
                    visited[r][c] = true;
                    queue.add(new int[]{r,c});
                }
            }
        }

        return result;
    }
}
