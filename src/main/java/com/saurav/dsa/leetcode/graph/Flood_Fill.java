package src.main.java.com.saurav.dsa.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
LeetCode 733 - Flood Fill
Difficulty: Easy
Link: https://leetcode.com/problems/flood-fill/

Problem:
Given a 2D array `image` representing an image, starting from the pixel (sr, sc),
replace the color of the starting pixel and all 4-directionally connected pixels
with the same original color with a new given color.

Approach:
- Use Breadth First Search (BFS) starting from (sr, sc).
- Store pixels to be filled in a queue as int arrays [row, col].
- For each pixel, check its 4-directionally adjacent neighbors.
- If a neighbor has the original color, change it to the new color and add it to the queue.

Complexity:
- Time Complexity: O(m * n), where m and n are the dimensions of the image, as each cell is visited at most once.
- Space Complexity: O(m * n), for the BFS queue in the worst case.
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color) return image;
        
        int[] rows = {0,-1,1,0}; // left, top, down, right
        int[] cols = {-1,0,0,1};

        int fill = image[sr][sc];

        Queue<int[]> queue = new LinkedList<>();

        image[sr][sc] = color;
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int row = queue.peek()[0]; // row
            int col = queue.peek()[1]; // col
            queue.remove();
            for(int i=0;i<4;i++){
                int r = row+rows[i];
                int c = col+cols[i];

                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==fill){
                    image[r][c] = color;
                    queue.add(new int[]{r,c});
                }
            }
        }

        return image;
    }
}
