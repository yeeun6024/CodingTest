import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] linked;
	static boolean[] visited;
	static int count = 0;
	
	static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1; i<=n; i++) {
			if(linked[x][i]==1 && !visited[i])
				dfs(i);
		}
	}

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();	// 노드의 개수
		m = s.nextInt();	// 간선의 개수
		linked = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			linked[x][y] = linked[y][x] = 1;
		}
		
		
		/* 깊이 우선 탐색 */
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		
		/* 출력 */
		System.out.println(count);

	}

}
