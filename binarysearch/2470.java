import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		/* 정렬 */
		Arrays.sort(arr);
		
		/* 합이 0에 가까운 두 값 찾기 */
		int ans1 = 0;
		int ans2 = 0;
		
		int min = 2000000000;
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			int temp = Math.abs(sum);
			
			if(temp < min) {	// 지정된 최소값 보다 작은 합이 나오면 갱신
				min = temp;
				ans1 = arr[start];
				ans2 = arr[end];
			}
			
			if(sum > 0) end--;	// 합이 0보다 크면 오른쪽에서 하나 내림
			else start++;	// 작으면 왼쪽에서 하나 올림
		}
		
		/* 출력 */
		System.out.println(ans1+ " " + ans2);
		
	}

}
