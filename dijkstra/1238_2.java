
/* 시간 초과 */
/* 그냥 이런 방법도 있다 이거임 */


import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		
		int[][] node = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				node[i][j] = 10000001;	// Integer.MAX_VALUE하면 넘어가서 음수가 나옴
			}
			node[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			if(node[start][end] > cost)
				node[start][end] = cost;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(node[i][j] > node[i][k] + node[k][j])
						node[i][j] = node[i][k] + node[k][j];
				}
			}
		}
			
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, node[i][x] + node[x][i]);
		}
		System.out.println(max);
		
	}

}
