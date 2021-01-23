import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] count = new int[25*25];	// 각 단지의 사람 수
	static int index = 0;	// 단지 번호
	static int[] dx = {0,0,-1,1};	// 상하좌우
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int i, int j) {		// 깊이 우선 탐색
		visited[i][j] = true;
		count[index]++;
		
		for(int dir=0; dir<4; dir++) {
			int x = i + dx[dir];
			int y = j + dy[dir];
			
			if(x>=0 && y>=0 && x<n && y<n) {
				if(map[x][y]==1 && !visited[x][y]) {
					dfs(x,y);
				}
			}
		}
		
	}
	
	static void bfs(int i, int j) {		// 너비 우선 탐색
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		count[index]++;
		
		while(!queue.isEmpty()) {
			int[] location = queue.poll();
			
			for(int dir=0; dir<4; dir++) {
				int x = location[0] + dx[dir];
				int y = location[1] + dy[dir];
				
				if(x>=0 && y>=0 && x<n && y<n) {
					if(map[x][y]==1 && !visited[x][y]) {
						queue.offer(new int[] {x,y});
						visited[x][y] = true;
						count[index]++;
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = s.next();
			
			for(int j=0; j<n; j++) {	
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
				
		/* 너비 우선 탐색 */
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					index++;
					//bfs(i,j);
					dfs(i,j);
				}
			}
		}
		
		
		/* 정렬 */
		Arrays.sort(count);
		
		
		/* 출력 */
		System.out.println(index);
		
		for(int i=0; i<count.length; i++) {
			if(count[i]==0)	continue;
			
			System.out.println(count[i]);
		}

	}

}
