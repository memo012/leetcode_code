package com.adminsys.code.图像渲染;

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    class Node{
        int x;
        int y;
        Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null && image[0].length == 0){
            return null;
        }
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        Queue<Node> queue = new LinkedList<>();
        int[][] book = new int[image.length][image[0].length];
        queue.add(new Node(sr, sc));
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int ttx = node.x;
            int tty = node.y;
            for(int i = 0; i < 4; i++){
                int tx = ttx + next[i][0];
                int ty = tty + next[i][1];
                if (tx < 0 || tx >= image.length || ty < 0 || ty >= image[0].length){
                    continue;
                }
                if (book[tx][ty] == 0 && image[tx][ty] == color){
                    book[tx][ty] = 1;
                    image[tx][ty] = newColor;
                    queue.add(new Node(tx, ty));
                }
            }
        }
        return image;
    }
}