import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int[] parent;
	static boolean[] visited;
	
	static void dfs(int node) {
		visited[node] = true;
		
		for(int x : list[node]) {
			if(!visited[x]) {
				parent[x] = node;
				dfs(x);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		parent = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
		
		
	}

}
