import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static int[] dx = {0,0,-1,1};	// 상하좌우
	static int[] dy = {1,-1,0,0};
	static int max = 0;
	
	static void bfs() {	// 바이러스 확산
		int[][] copymap = copy(map);	// 원래 데이터를 보존하기 위함
		
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copymap[i][j]==2) {	// 바이러스를 모두 큐에 삽입.
					queue.offer(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			
			for(int k=0; k<4; k++) {
				int x = loc[0] + dx[k];
				int y = loc[1] + dy[k];
				
				if(x>=0 && x<n && y>=0 && y<m) {
					if(copymap[x][y]==0) {
						queue.offer(new int[] {x,y});
						copymap[x][y] = 2;
					}
				}
			}
			
		}
		
		int count = count(copymap);
		max = Math.max(max, count);
		
	}
	
	static void makeWall(int depth) {	// 벽을 세우는 함수
		if(depth==3) {
			bfs();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(depth+1);
					map[i][j] = 0;	// 위의 함수가 끝나면 다시 원상복귀
				}
			}
		}
	}
	
	static int count(int[][] map) {	// 바이러스 없는 곳 카운트
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0)
					count++;
			}
		}
		
		return count;
	}
	
	static int[][] copy(int[][] map) {	// 깊은 복사
		int[][] copymap = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		
		return copymap;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0);
		
		System.out.println(max);

	}

}
