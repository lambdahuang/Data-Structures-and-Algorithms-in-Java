### BFS 

* index = x*n + y

```
public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0) return res;
        if( grid[0] == null || grid[0].length == 0 ) return res;
        int row = grid.length;
        int col = grid[0].length;
        for( int i = 0 ; i < row ; i ++) {
            for(int j = 0 ; j < col ; j++ ){
                if(grid[i][j] == '1'){
                    bfs(grid, row, col, i, j);
                    res++;   
                }
            }
        }
        return res;
       
    }
    public void bfs(char[][] grid, int m, int n, int x, int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(x*n+y);
        grid[x][y] = '0';
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int curX = cur/n;
            int curY = cur%n;
            for(int i = -1; i <= 1 ; i++ ){
                for(int j = -1 ; j <= 1; j++){
                    if( isValid(i, j, curX, curY, m, n) && grid[curX+i][curY+j] == '1'){
                        queue.offer((curX+i) * n + (curY+j));
                        grid[curX+i][curY+j] = '0'; 
                    }
                }
            }
        }
    }
    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >=0 && i+x < row && j+y >= 0 && j+y < col && Math.abs(i) != Math.abs(j);
    }
}
```



### DFS 

```
public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0) return res;
        if( grid[0] == null || grid[0].length == 0 ) return res;
        int row = grid.length;
        int col = grid[0].length;
        for( int i = 0 ; i < row ; i ++) {
            for(int j = 0 ; j < col ; j++ ){
                if(grid[i][j] == '1'){
                    removeIsland(grid, row,col, i, j);
                    res++;   
                }
            }
        }
        return res;
        
    }
    private void removeIsland(char[][] grid, int row, int col, int x ,int y){
        grid[x][y] = '0';
        for(int i = -1 ; i <= 1 ; i++ ){
            for( int j = -1 ; j <= 1 ; j++ ){
                if(isValid(i,j,x,y,row,col) && grid[x+i][y+j] == '1'){
                    removeIsland(grid,row,col,x+i,y+j);
                }
            }
        }
    }
    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >=0 && i+x < row && j+y >= 0 && j+y < col && Math.abs(i) != Math.abs(j);
    }
}

```



### Calculate islands of max size


```

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

class myCode {
    public static void main(String[] args) {
        int[][] n = {
                {1,1,1,1,0},
                {1,1,0,0,1},
                {0,0,0,1,1},
                {1,1,0,1,0},
        };
        myCode sol = new myCode();
        int res = sol.checkMaxSize(n);
        System.out.println(res);

    }

    

    public int checkMaxSize(int[][] n) {
        int res = Integer.MIN_VALUE;
        if (n == null || n.length == 0) return res;
        if (n[0] == null || n[0].length == 0) return res;
        int row = n.length;
        int col = n[0].length;
        int[][] temp = new int[row][col];

        for( int i = 0 ; i < row ; i++){
            for( int j = 0 ; j < col ; j++){
                temp[i][j] = n[i][j];
            }

        }

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if (temp[i][j] == 1) {
                    size++;
                    int t = checkSize(temp,row,col,i,j);
                    if( res < t ){
                        res = t;
                    }
                    size = 0;
                }
            }
        }
        return res;
    }
    
    int size = 0;
    private int checkSize(int[][] temp, int row, int col, int x, int y) {
        temp[x][y] = 0;
        for (int i = -1; i <= 1 ; i++) {
            for ( int j = - 1; j <= 1 ; j++ ){
                if( isValid( i , j , x , y , row , col ) && temp[x+i][y+j] == 1 ){
                    checkSize( temp , row , col , x+i, y+j);
                    size++;
                }
            }
        }
        
        return size;
    }

    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >=0 && i+x < row && j+y >= 0 && j+y < col && Math.abs(i) != Math.abs(j);
    }
}

```