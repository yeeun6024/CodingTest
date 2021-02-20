import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long k = s.nextLong();
		
		/* 계산 */
		long start = 1;
		long end = k;
		long answer = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for(int i=1; i<=n; i++) {
				sum += Math.min(mid/i, n);	// 계산방법
			}
			
			if(sum < k) start = mid + 1;
			else {
				answer = mid;
				end = mid - 1;
			}
			
		}
		
		/* 출력 */
		System.out.println(answer);

	}

}
