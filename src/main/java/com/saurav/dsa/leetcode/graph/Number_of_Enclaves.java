package src.main.java.com.saurav.dsa.leetcode.graph;

/*
LeetCode 1020 - Number of Enclaves
Difficulty: Medium
Link: https://leetcode.com/problems/number-of-enclaves/

Problem:
You are given an m x n binary matrix `grid` where 1 represents land and 0 represents water.
A move consists of walking from one land cell to another adjacent land cell (4-directionally).
An enclave is a land cell that cannot reach the grid boundary by any number of moves.

Return the number of land cells that form enclaves.

Approach:
- Perform DFS from all boundary land cells (first row, last row, first column, last column).
- Mark all reachable land cells (connected to the boundary) as visited by setting them to -1.
- After the DFS traversal, count all remaining cells with value 1 — these are enclaves.

Complexity:
- Time Complexity: O(m × n), since every cell is visited at most once.
- Space Complexity: O(m × n) in the worst case (due to recursive DFS stack).
*/
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(i,0,grid);
            if(grid[i][n-1]==1) dfs(i,n-1,grid);
        }

        for(int i=0;i<n;i++){
            if(grid[0][i]==1) dfs(0,i,grid);
            if(grid[m-1][i]==1) dfs(m-1,i,grid);
        }
        
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1) return;

        grid[row][col] = -1;

        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col-1,grid);
        dfs(row,col+1,grid);
    }
}
