import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int depth, int start) {
		if(depth == m) {
			calDist();
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			list.add(chicken.get(i));
			dfs(depth+1, i+1);
			list.remove(list.size()-1);
		}
	}
	
	static void calDist() {
		int sum = 0;
				
		for(int[] home : home) {
			int min = Integer.MAX_VALUE;
			for(int[] temp : list) {
				int dist = Math.abs(temp[0]-home[0]) + Math.abs(temp[1]-home[1]);
				min = Math.min(min, dist);
			}
			sum += min;
			
		}
		
		min = Math.min(min, sum);
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) home.add(new int[] {i,j});
				else if(arr[i][j]==2) chicken.add(new int[] {i,j});
			}
		}
		
		dfs(0,0);
		
		System.out.println(min);
		
		
	}

}
