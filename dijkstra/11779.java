import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static List<Node>[] list;
	static int[] dist, route;
	static List<Integer> routes = new ArrayList<>();
	
	static void dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		queue.add(new Node(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cur = node.end;
						
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Node n : list[cur]) {
					if(dist[n.end] > dist[cur] + n.weight) {
						dist[n.end] = dist[cur] + n.weight;
						queue.add(new Node(n.end, dist[n.end]));
						route[n.end] = cur;
					}
				}
				
			}
		
		}
		
		int node = end;
		while(node != 0) {
			routes.add(node);
			node = route[node];
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); // 도시의 개수
		m = Integer.parseInt(br.readLine()); // 버스의 개수
		list = new ArrayList[n+1];
		dist = new int[n+1];
		route = new int[n+1];
				
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());
		
		dijkstra(startNode, endNode);
		
		System.out.println(dist[endNode]);
		System.out.println(routes.size());
		for(int i=routes.size()-1; i>=0; i--) {
			System.out.print(routes.get(i) + " ");
		}

	}
	
	static class Node implements Comparable<Node> {
		
		int end, weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	}

}
