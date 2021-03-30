import java.io.*;
import java.util.*;

class Node3 implements Comparable<Node3> {
	
	int end, weight;
	
	Node3(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node3 o) {
		return weight - o.weight;
	}
	
}

public class Main {
	
	static int n, e;
	static List<Node3>[] list;
	static int[] dist;
	static final int INF = 200000000;
	
	static int dijkstra(int start, int endNode) {
		Arrays.fill(dist, INF);
				
		PriorityQueue<Node3> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		queue.offer(new Node3(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node3 node = queue.poll();
			int end = node.end;
			int weight = node.weight;
			
			if(visited[end]) continue;
			
			visited[end] = true;
			
			for(Node3 n : list[end]) {
				if(dist[n.end] > dist[end] + n.weight) {
					dist[n.end] = dist[end] + n.weight;
					queue.add(new Node3(n.end, dist[n.end]));
				}
			}
		}
		
		return dist[endNode];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		dist = new int[n+1];

		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist,INF);
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node3(end,weight));
			list[end].add(new Node3(start,weight));	// 양방향이니까
		}
		
		st = new StringTokenizer(br.readLine());
		int v1= Integer.parseInt(st.nextToken());
		int v2= Integer.parseInt(st.nextToken());
		
		int res1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,n); // 1 -> v1 -> v2 -> n
		int res2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,n); // 1 -> v2 -> v1 -> n
		
		int answer = (res1>=INF && res2>=INF) ? -1 : Math.min(res1, res2);
		
		System.out.println(answer);
		
	}

}
