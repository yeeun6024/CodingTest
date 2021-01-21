import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, m, start;		// 정점의 개수, 간선의 개수, 시작할 정점
	static int[][] check;		// 연결 여부 배열
	static boolean[] checked;	// 방문 여부 
	
	static void dfs(int i) {	// 깊이 우선 탐색. 재귀적인 호출 사용
		checked[i] = true;
		
		System.out.print(i+" ");
		
		for(int j=1; j<=n; j++) {
			if(check[i][j] == 1 && !checked[j])	// 간선여부, 방문여부 확인
				dfs(j);
		}
	}
	
	static void bfs() {		// 너비 우선 탐색. 큐 사용
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		checked[start] = true;
		System.out.print(start+" ");
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			
			for(int j=1; j<=n; j++) {
				if(check[i][j] == 1 && !checked[j]) {	// 간선여부, 방문여부 확인
					queue.offer(j);
					checked[j] = true;
					System.out.print(j+" ");
				}
			}
		}
	}

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		start = s.nextInt();
		
		check = new int[n+1][n+1];
		checked = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			check[a][b] = check[b][a] = 1;	// 대칭
		}
		
		
		/* 깊이 우선 탐색 */
		dfs(start);
		
		System.out.println();

		
		/* 너비 우선 탐색 */
		checked = new boolean[n+1]; // 방문 기록 초기화
		bfs();		
		
	}

}
