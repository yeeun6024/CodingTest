import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
	
	int end, time;
	
	Student(int end, int time) {
		this.end = end;
		this.time = time;
	}

	@Override
	public int compareTo(Student o) {
		return time - o.time;
	}
		
}

public class Main {
	
	static int n, m, x;
	static List<Student>[] list, revList;	// 가는거 하나 오는거 하나
	static int[] dist, revDist;
	
	public static void dijkstra(List<Student>[] list, int[] dist, int start) {
		PriorityQueue<Student> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		queue.add(new Student(start,0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Student s = queue.poll();
			int cur = s.end;
			
			if(visited[cur]) continue;
			
			visited[cur] = true;
			
			for(Student stu : list[cur]) {
				if(dist[stu.end] > dist[cur] + stu.time) {
					dist[stu.end] = dist[cur] + stu.time;
					queue.add(new Student(stu.end, dist[stu.end]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		revList = new ArrayList[n+1];
		dist = new int[n+1];
		revDist = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			revList[i] = new ArrayList<>();
		}
		
		Arrays.fill(dist,Integer.MAX_VALUE);
		Arrays.fill(revDist,Integer.MAX_VALUE);
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list[start].add(new Student(end,time));
			revList[end].add(new Student(start,time));	// 이렇게 뒤집으면 2로 가는게 됨. 개신기
		}
		
		dijkstra(list, dist, x);
		dijkstra(revList, revDist, x);
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dist[i]+revDist[i]);
		}
		System.out.println(max);

	}

}
