/**
 *
 * 2020 카카오 인턴 : 경주로 건설      실패!
 *
 */


import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] cost = new int[n][n];
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        queue.add(new int[] {0,0,-1});
        //int min = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        cost[0][0] = 0;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int dir = temp[2];
            
            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n) {
                    if(board[nextX][nextY]!=1) {
                        int sum = 0;
                        if(dir==-1 || dir==i) sum = cost[x][y] + 100;
                        else sum = cost[x][y] + 600;
                        
                        if(cost[nextX][nextY]>=sum) {
                            cost[nextX][nextY] = sum;
                            queue.add(new int[] {nextX, nextY, i});
                        }
                    }
                }
            }
        }
        
        return cost[n-1][n-1];
    }
}
