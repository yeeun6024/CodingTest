import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int max = 0;
	static int maxIdx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start,weight));
		}
		
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1,0);
		
		visited = new boolean[n+1];
		visited[maxIdx] = true;
		dfs(maxIdx,0);
		System.out.println(max);
		
	}
	
	static void dfs(int index, int cnt) {
		if(max < cnt) {
			max = cnt;
			maxIdx = index;
		}
		
		for(Node n : list[index]) {
			if(!visited[n.index]) {
				visited[n.index] = true;
				dfs(n.index, cnt+n.weight);
			}
		}
	}
	
	static class Node {
		int index, weight;
		
		Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}

}
