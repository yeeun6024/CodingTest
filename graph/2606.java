import java.util.*;

public class Main {
	
	static int n, m;
	static boolean[][] linked;
	static boolean[] visited;
	static int count = 0;
	
	static void dfs(int start) {
		visited[start] = true;
		
		for(int i=1; i<=n; i++) {
			if(linked[start][i] && !visited[i]) {
				count++;
				dfs(i);
			}	
		}
		
	}

	public static void main(String[] args) {
		
		/* 입력 */ 
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		linked = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		
		for(int i=0; i<m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			linked[x][y] = true;
			linked[y][x] = true;
		}
		
		
		/* 깊이 우선 탐색 */
		dfs(1);
		
		
		/* 출력 */
		System.out.println(count);

	}

}
