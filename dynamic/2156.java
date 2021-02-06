import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] amount = new int[n+1];
		int[] sum = new int[n+1];
		
		for(int i=1; i<amount.length; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		
		
		/* 최대로 마실 수 있는 포도주의 양 계산 */
		sum[1] = amount[1];
		
		if(n>=2)
			sum[2] = amount[1] + amount[2];
		
		for(int i=3; i<amount.length; i++) {
			sum[i] = Math.max(sum[i-1],Math.max(sum[i-2], sum[i-3] + amount[i-1]) + amount[i]);
		}
		
		
		/* 최댓값 출력 */
		System.out.println(sum[n]);
		
	}

}
