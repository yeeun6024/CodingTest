import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		StringTokenizer st;
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/* 계산(i부터 마지막날까지의 최대수익: dp[i]) */
		int[] dp = new int[n+2];
		
		for(int i=n; i>0; i--) {
			if(i+t[i] > n+1)	// n+1인 이유는 t[i]가 1일 수 있기 때문에. 1이면 p[i]를 더해줘야하기때문에 밑으로 가야함.
				dp[i] = dp[i+1];
			else
				dp[i] = Math.max(dp[i+1],p[i]+dp[i+t[i]]); 
			// 다음날부터의 최대수익과 오늘의 수익+그 후의 최대수익 중 큰 것을 선택 
		}
		
		System.out.println(dp[1]);
		
	}

}
