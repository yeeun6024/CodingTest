import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] isUsed;
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int index, int depth) {
		if(depth==n/2) {
			calc();
			return;
		}
		
		for(int i=index; i<n; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				dfs(i+1, depth + 1);				
				isUsed[i] = false;
			}
		}
		
	}
	
	static void calc() { // 각각 합 계산. 차이 계산.
		int sumStart = 0;
		int sumLink = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(isUsed[i] && isUsed[j]) {
					sumStart += arr[i][j];
					sumStart += arr[j][i];
				}
				else if(!isUsed[i] && !isUsed[j]) {
					sumLink += arr[i][j];
					sumLink += arr[j][i];
				}
					
			}
		}
		
		if(min > Math.abs(sumStart - sumLink))
			min = Math.abs(sumStart - sumLink);
		
		if(min==0) { // 0 이면 바로 종료되도록
			System.out.println(min);
			System.exit(0);
		}
		
	}	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		isUsed = new boolean[n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		dfs(0,0);
		
		System.out.println(min);
		
	}

}
