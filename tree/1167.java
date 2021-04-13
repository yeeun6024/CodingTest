import java.util.*;

public class Main {
	
	static int v;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int max = 0;
	static int maxIdx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		list = new ArrayList[v+1];
		
		for(int i=0; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			int x = sc.nextInt();
			
			while(true) {
				int index = sc.nextInt();
				if(index==-1) break;
				
				int weight = sc.nextInt();
				
				list[x].add(new Node(index,weight));
			}
		}
		
		visited = new boolean[v+1];
		visited[1] = true;
		dfs(1,0);
		
		visited = new boolean[v+1];
		visited[maxIdx] = true;
		dfs(maxIdx,0);
		
		System.out.println(max);	

	}
	
	static void dfs(int index, int cnt) {
		if(max < cnt) {
			maxIdx = index;
			max = cnt;
		}
		
		for(Node n : list[index]) {
			if(!visited[n.index]) {
				visited[n.index] = true;
				dfs(n.index,cnt+n.weight);
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
