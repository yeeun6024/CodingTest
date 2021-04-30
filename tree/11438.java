/**
 *
 *  실패^^ 모르겠어^^^^^^^^^^^^^^^^^^ 막 비트연산이 나와^^^^^^^^^^^ 일단 이 코드는 시간 초과
 *
 */



import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int[] depth, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		 
		int n = Integer.parseInt(br.readLine());
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
		
		for(int n : list[node]) {
			if(depth[n]!=0) continue;
			parent[n] = node;
			dfs(n,cnt+1);
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
