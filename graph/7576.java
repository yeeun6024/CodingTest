import java.util.*;

public class Main {
	
	static int m, n;
	static int[][] map;	// 토마토 위치
	static boolean[][] visited;	// 방문여부
	static int days = 0;	// 날짜
	static int[] dx = {0,0,-1,1};	// 상하좌우
	static int[] dy = {1,-1,0,0};
	
	static boolean ripenAll() {	// 모두 익었는지 확인하는 함수
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0)
					return false;
			}
		}
		
		return true;
	}
	
	static void bfs() {	// 너비 우선 탐색
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {	// 1인 모든 토마토를 큐에 넣는다.
			for(int j=0; j<m; j++) {
				if(map[i][j]==1) {
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] location;
			int size = queue.size();
			days++;
			
			for(int i=0; i<size; i++) {	// 현재 큐에 있는 수만큼 꺼내겠다.
				location = queue.poll();
				
				for(int j=0; j<4; j++) {
					int x = location[0] + dx[j];
					int y = location[1] + dy[j];
					

					if(x>=0 && y>=0 && x<n && y<m) {
						if(map[x][y]!=-1 && !visited[x][y]) {
							queue.offer(new int[] {x,y});
							visited[x][y] = true;
							map[x][y] = map[location[0]][location[1]]+1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		m = s.nextInt();
		n = s.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = s.nextInt();
			}
		}
		
		
		/* 최소 날짜 출력 */
		if(ripenAll()) {	// 모두 익었으면 0출력
			System.out.println(0);
		}
		else {	// 모두 익지 않았을 경우
			bfs();
			
			if(ripenAll()) {
				System.out.println(days-1);	// 최소날짜는 첫날 제외해야한다.
			}
			else 
				System.out.println(-1);
		}
		

	}

}
