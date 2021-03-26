import java.io.*;
import java.util.*;

class Node1 implements Comparable<Node1> {
	
	int end, cost;
	
	public Node1(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node1 o) {
		return cost - o.cost;
	}
	
}

public class Main {
	
	static int n, m;
	static List<Node1>[] list;
	static int[] cost;
	
	static void dijkstra(int start) {
		PriorityQueue<Node1> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		queue.add(new Node1(start,0));
		cost[start] = 0;
		
		while(!queue.isEmpty()) {
			Node1 loc = queue.poll();
			int end = loc.end;
			int c = loc.cost;
			
			if(visited[end]) continue;
			visited[end] = true;
			
			for(Node1 node : list[end]) {
				if(cost[node.end] > cost[end] + node.cost) {
					cost[node.end] = cost[end] + node.cost;
					queue.add(new Node1(node.end, cost[node.end]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 도시의 개수
		m = Integer.parseInt(br.readLine());	// 버스의 개수
		list = new ArrayList[n+1];
		cost = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		StringTokenizer st;
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node1(end, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(cost[end]);
		
	}

}
