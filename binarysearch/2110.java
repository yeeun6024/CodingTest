import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = s.nextInt();
		int[] house = new int[n];
		
		for(int i=0; i<n; i++) {
			house[i] = s.nextInt();
		}
		
		
		/* 정렬 */
		Arrays.sort(house);
		
		
		/* 이분탐색(거리를 이분탐색해서 찾는다) */
		int min = 1;	// 가장 짧은 거리는 1
		int max = house[n-1] - house[0];	// 가장 먼 거리는 맨 끝집 사이
		int answer = 0;		// 답을 담을 변수
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int prevHouse = house[0];	// 거리를 비교할 집
			int count = 1;	// 집의 수. 첫번째 집이 포함되어 있음.
			
			for(int i=0; i<n; i++) {
				int distance = house[i] - prevHouse;	// 비교할 집과 하나씩 거리를 잼
				if(distance >= mid) {	// mid보다 크면 집 추가, 비교할 집 교체
					count++;
					prevHouse = house[i];
				}
			}
			
			if(count >= c) {	// 위의 집의 수가 공유기의 수보다 크거나 같으면 거리를 늘린다.
				min = mid + 1;
				answer = mid;
			}
			else max = mid - 1;		// 위의 집의 수가 공유기의 수보다 작으면 거리를 줄인다.
		}
		
		
		/* 출력 */
		System.out.println(answer);
		

	}

}
