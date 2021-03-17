import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int count = 0;
	static int max = 0;
	static int height = 0;
	static int tallest = 0;
	
	static void bfs(int[][] arr, int i, int j) { // 영역 판단
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			
			for(int k=0; k<4; k++) {
				int x = loc[0] + dx[k];
				int y = loc[1] + dy[k];
				
				if(x>=0 && x<n && y>=0 && y<n) {
					if(!visited[x][y] && arr[x][y]>height) {
						queue.offer(new int[] {x,y});
						visited[x][y] = true;
					}
				}
			}
			
		}
		
	}
	
	static void dfs(int[][] arr) { // 물에 잠긴 영역 개수 계산
		if(height == tallest) return;
		
		visited = new boolean[n][n];
		count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && arr[i][j]>height) {
					bfs(arr,i,j);
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
		height++;
		dfs(arr);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tallest = (tallest < arr[i][j] ? arr[i][j] : tallest);
			}
		}
		
		dfs(arr);
		
		System.out.println(max);

	}

}
