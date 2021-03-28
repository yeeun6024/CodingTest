import java.util.*;

class Point implements Comparable<Point> {
	
	int x, y, cost;
	
	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point o) {
		return cost - o.cost;
	}
	
}

public class Main {
	
	static int n, m;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static int bfs(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[n+1][m+1]; 
		queue.add(new Point(x,y,0));
		visited[x][y] = true;

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x==n && p.y==m) return p.cost;
			
			for(int i=0; i<4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX>=1 && nextX<=n && nextY>=1 && nextY<=m) {
					if(!visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						if(map[nextX][nextY]==0) {
							queue.add(new Point(nextX,nextY,p.cost));
						}
						else {
							queue.add(new Point(nextX,nextY,p.cost+1));
						}
					}
						
				}
			}
        }
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		map = new int[n+1][m+1];

		for(int i=1; i<=n; i++) {
			String str = sc.next();
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}

		int count = bfs(1,1);
		
		System.out.println(count);

	}

}
