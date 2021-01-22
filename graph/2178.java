import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();	// n
		int m = s.nextInt();	// m
		
		int[][] map = new int[n+1][m+1];	// 미로
		boolean[][] visited = new boolean[n+1][m+1];	// 방문 여부
		
		for(int i=1; i<=n; i++) {
			String string = s.next();
			
			for(int j=1; j<=m; j++) {
				map[i][j] = string.charAt(j-1) - '0';
			}
		}
		
		
		/* 지나는 칸 수 계산 (너비 우선 탐색) */
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1,1});	// 출발점 큐에 넣음
		visited[1][1] = true;	// 출발점 방문 완료
		int[] h = {1,0,-1,0};	// 3,6,9,12 방향 좌우
		int[] v = {0,-1,0,1};	// 상하
		
		while(!queue.isEmpty()) {
			int[] location = queue.poll();	// 큐 하나 꺼내기
			
			for(int i=0; i<4; i++) {	// 상하좌우, 조건에 맞춰 큐에 넣기
				int x = location[0] + h[i];
				int y = location[1] + v[i];
				
				if(x>=1 && y>=1 && x<=n && y<=m) {
					if(map[x][y]!=0 && !visited[x][y]) {
						queue.offer(new int[] {x,y});
						visited[x][y] = true;
						map[x][y] = map[location[0]][location[1]] + 1;	// 지나는 칸 수 계산
					}
				}
			}	
		}
		
		
		/* 출력 */
		System.out.println(map[n][m]);
		
	}

}
