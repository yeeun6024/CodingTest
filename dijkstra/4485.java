import java.io.*;
import java.util.*;

public class Main {
	
	static class Point implements Comparable<Point> {
		
		int row, col, cost;
		
		Point(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return cost - o.cost;
		}
		
	}
	
	static int n;
	static int[][] arr, min;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		min[0][0] = arr[0][0];
		queue.add(new Point(0,0,arr[0][0]));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int k=0; k<4; k++) {
				int nextRow = p.row + dy[k];
				int nextCol = p.col + dx[k];
				
				if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n) {
					if(min[nextRow][nextCol] > min[p.row][p.col] + arr[nextRow][nextCol]) {
						min[nextRow][nextCol] = min[p.row][p.col] + arr[nextRow][nextCol];
						queue.add(new Point(nextRow, nextCol, min[nextRow][nextCol]));
					}
				}
			}
		}
		
		return min[n-1][n-1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count = 0;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
						
			arr = new int[n][n];
			min = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					min[i][j] = Integer.MAX_VALUE;
				}
			}
			
			count++;
			sb.append("Problem " + count+ ": "+ dijkstra() + "\n");
			
		}
		
		System.out.println(sb);

	}

}
