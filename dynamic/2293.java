import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 받기 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] x = new int[n];	// 코인 배열
		int[] dp = new int[k+1];	// 경우의 수 배열
		
		for(int i=0; i < n; i++) {
			x[i] = s.nextInt();
		}
		
		/* 경우의 수 구하기 */ 
		dp[0] = 1 ;
		
		for(int i=0; i<n; i++) {
			for(int j=x[i]; j<=k; j++) {
				dp[j] += dp[j-x[i]];
			}
		}
		
		/* 출력 */
		System.out.println(dp[k]);

	}

}
