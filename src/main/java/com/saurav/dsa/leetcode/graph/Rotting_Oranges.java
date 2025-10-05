package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LeetCode 994 - Rotting Oranges
Difficulty: Medium
Link: https://leetcode.com/problems/rotting-oranges/

Problem:
You are given an `m x n` grid where each cell can be:
- 0: empty
- 1: fresh orange
- 2: rotten orange

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no fresh orange remains.
If it is impossible to rot all oranges, return -1.

Approach:
- Use Breadth First Search (BFS) starting from all initially rotten oranges.
- Track the number of fresh oranges.
- For each rotten orange in the queue, rot its adjacent fresh oranges, mark them as rotten, and add them to the queue with incremented time.
- Keep track of the last time step; if all fresh oranges become rotten, return it; otherwise, return -1.

Complexity:
- Time Complexity: O(m * n), as each cell is visited at most once.
- Space Complexity: O(m * n), for the BFS queue in the worst case.
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        // Mark rotten oranges
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int[] rows = {0,-1,1,0}; // left, top, bottom, right
        int[] cols = {-1,0,0,1};
        int count = 0;
        int rotten = 0;

        while(!queue.isEmpty()){
            int r = queue.peek()[0]; // row
            int c = queue.peek()[1]; // col
            count = queue.peek()[2]; // lvl
            queue.remove();
            for(int i=0;i<4;i++){
                int row = r+rows[i];
                int col = c+cols[i];

                if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1){
                    grid[row][col]=2;
                    queue.add(new int[]{row,col,count+1});
                    rotten++;
                }
            }
        }

        if(rotten!=fresh) return -1;

        return count;
    }
}