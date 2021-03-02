import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 카드의 개수
		int m = Integer.parseInt(st.nextToken());	// 최대 합
		int[] card = new int[n];	// 숫자를 담을 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/* 세 개의 수의 최대값 찾기 */
		int sum = 0;
		int max = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					sum = card[i] + card[j] + card[k];
					
					if(sum >= max && sum <= m)
						max = sum;
				}
			}
		}
		
		
		/* 출력 */
		System.out.println(max);

	}

}
