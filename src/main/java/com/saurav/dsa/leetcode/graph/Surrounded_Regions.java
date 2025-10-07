package src.main.java.com.saurav.dsa.leetcode.graph;

/**
 * LeetCode: 130. Surrounded Regions
 * 
 * Approach Summary:
 * - The idea is to capture all 'O' regions that are completely surrounded by 'X'.
 * - Any 'O' connected to a boundary 'O' cannot be captured, so we start a BFS
 *   from all border 'O's and mark them as safe (visited = 1).
 * - After BFS, all unvisited 'O's are fully surrounded and can be flipped to 'X'.
 * 
 * Steps:
 * 1. Add all boundary 'O's to a queue and mark them visited.
 * 2. Use BFS to traverse their connected 'O' regions and mark them visited.
 * 3. Finally, flip all unvisited 'O's to 'X' (captured regions).
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 * 
 * Clean and efficient BFS solution (accepted on LeetCode)
 */

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }

        int[] rows = {0,-1,1,0}; // left, top, down, right
        int[] cols = {-1,0,0,1};

        while(!queue.isEmpty()){
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.remove();
            for(int i=0;i<4;i++){
                int r = row+rows[i];
                int c = col+cols[i];

                if(r>=0 && r<m && c>=0 && c<n && visited[r][c]==0 && board[r][c]=='O'){
                    queue.add(new int[]{r,c});
                    visited[r][c] = 1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}