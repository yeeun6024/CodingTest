import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] arr, change;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[n+1][n+1];
		queue.add(new Node(1,1,0));
		change[1][1] = arr[1][1];
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			
			if(x==n && y==n) break;
			
			if(!visited[x][y]) {
				visited[x][y] = true;
				
				for(int i=0; i<4; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];
					
					if(nextX>0 && nextX<=n && nextY>0 && nextY<=n) {
						if(change[nextX][nextY] > arr[nextX][nextY] + change[x][y]) {
							change[nextX][nextY] = arr[nextX][nextY] + change[x][y];
							queue.add(new Node(nextX, nextY, change[nextX][nextY]));
						}
					}
				}
			}
		}
			
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		change = new int[n+1][n+1];	// 교체되는 블럭의 최소 수
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j-1)+"")==1? 0 : 1;  // 1이면 0, 0이면 1로 교체
				change[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dijkstra();
		
		System.out.println(change[n][n]);
		
	}
	
	static class Node implements Comparable<Node> {
		
		int x, y, cost;
		
		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
		
	}
	

}
