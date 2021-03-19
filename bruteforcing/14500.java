import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int max = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
		
	static void dfs(int depth, int x, int y, int sum) {
		if(x<0 || x>=n || y<0 || y>=m)
			return;
		
		if(depth==4) {
			max = Math.max(max, sum);
			return;
		}
		
		if(!visited[x][y]) {
			visited[x][y] = true;
			sum += arr[x][y];
			dfs(depth+1,x,y+1,sum); // 상
			dfs(depth+1,x,y-1,sum); // 하
			dfs(depth+1,x-1,y,sum); // 좌
			dfs(depth+1,x+1,y,sum); // 우
			sum -= arr[x][y];
			visited[x][y] = false;
		}

	}
	
	static void tShape(int x, int y) {
		int sum = arr[x][y];
		int wing = 4;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(wing < 3) return;
			
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >=m) {
				wing--;
				continue;
			}
			
			min = Math.min(min, arr[nextX][nextY]);
			sum += arr[nextX][nextY];
			
		}
		
		if(wing == 4) sum -= min;
		
		max = Math.max(max, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(0,i,j,0);
				tShape(i,j);
			}
		}
		
		System.out.println(max);

	}

}
