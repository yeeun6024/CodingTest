import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {

	int end, weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
	
}

public class Main {
	
	static int v, e, k;
	static List<Node>[] list;
	static int[] dist;
	
	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[v+1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.end;
			
			if(check[cur]) continue;
			check[cur] = true;
			
			for(Node node : list[cur]) {
				if(dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());	// 노드의 수
		e = Integer.parseInt(st.nextToken());	// 간선의 수
		k = Integer.parseInt(br.readLine());	// 시작 점
		
		list = new ArrayList[v+1];
		dist = new int[v+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		dijkstra(k);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
		
	}

}
