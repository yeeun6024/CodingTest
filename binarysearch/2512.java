import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	// 지방의 수
		int[] request = new int[n];		// 각 지방의 요청 예산
		int total = 0;
		
		for(int i=0; i<n; i++) {
			request[i] = s.nextInt();
			total += request[i];
		}
		
		int budget = s.nextInt();	// 총 예산
		
		Arrays.sort(request);
		int max = request[n-1]; 	// 가장 큰 요청 예산 
		
		if(total <= budget) {	// 예산의 합이 총액보다 작거나 같으면 가장 큰 요청 예산 출력
			System.out.println(max);	
			return;
		}
		
		
		/* 이분탐색 */
		int start = 1;
		int end = budget;
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i=0; i<n; i++) {	// 배정된 예산의 함을 구한다
				if(mid >= request[i])	sum += request[i];
				else sum += mid;
			}
			
			if(sum > budget) {	// 예산을 넘으면 범위를 줄인다.
				end = mid - 1;
			}
			else {
				start = mid + 1;
				answer = mid;
			}
		}
		
				
		/* 출력 */
		System.out.println(answer);
		
	}

}
