import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Integer>[] list;
	static int[] depth, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		depth = new int[n+1];
		parent = new int[n+1];
		dfs(1,1);
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(solve(x,y)+"\n");
		}
		
		System.out.println(sb);
		

	}
	
	static void dfs(int node, int cnt) {
		depth[node] = cnt;
		
		for(int child : list[node]) {
			if(depth[child]==0) {
				dfs(child, cnt+1);
				parent[child] = node;
			}
		}
	}
	
	static int solve(int x, int y) {
		
		while(depth[x] > depth[y]) {
			x = parent[x];
		}
		
		while(depth[x] < depth[y]) {
			y = parent[y];
		}
		
		while(x!=y) {
			x = parent[x];
			y = parent[y];
		}
		
		return x;
	}

}
