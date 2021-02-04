import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		/* 경로의 합 계산 */
		int floor = 1;
		
		while(floor < n) {
			tri[floor][0] += tri[floor-1][0];	// 맨 왼쪽
			tri[floor][floor] += tri[floor-1][floor-1];	// 맨 오른쪽
			
			for(int i=1; i<floor; i++) {
				tri[floor][i] += Math.max(tri[floor-1][i-1], tri[floor-1][i]);
			}
			
			floor++;
		}
		
		
		/* 최대값 계산 & 출력 */
		int max = tri[n-1][0];
		for(int i=1; i<n; i++) {
			if(max < tri[n-1][i])
				max = tri[n-1][i];
		}
		
		System.out.println(max);

	}

}
