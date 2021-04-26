package tree;

import java.io.*;
import java.util.*;

public class Ex_11438 {
	
	static ArrayList<Integer>[] list;
	static int[] depth;
	static int[][] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		depth = new int[n+1];
		parent = new int[n+1][100001];
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		}

	}
	
	static void dfs(int node, int cnt) {
		depth[node] = cnt;
		for(int n : list[node]) {
			if(depth[n]!=0) continue;
			parent[n][0] = node;
			dfs(n,cnt+1);
		}
	}

}
