import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());	// T 입력
		
		int n = Integer.parseInt(br.readLine());	// n 입력
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());	// A 입력
		}
		
		int m = Integer.parseInt(br.readLine());	// m 입력
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			B[i] = Integer.parseInt(st.nextToken());	// B 입력
		}
		
		
		/* 부분합 만들기*/
		// A의 부분합
		ArrayList<Integer> listA = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}
		
		// B의 부분합
		ArrayList<Integer> listB = new ArrayList<>();
		for(int i=0; i<m; i++) {
			int sum = 0;
			for(int j=i; j<m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}
		
		
		/* 부분합 정렬 */
		Collections.sort(listA);
		Collections.sort(listB);
		
		
		/* 두 포인터를 이용한 합 구하기 */
		int p1 = 0;
		int p2 = listB.size() - 1;
		long count = 0;
		
		while(p1 < listA.size() && p2 >= 0) {
			int p11 = listA.get(p1);
			int p22 = listB.get(p2);
			long count1 = 0;
			long count2 = 0;
			
			if(p11 + p22 == T) {
				while(p1 < listA.size() && listA.get(p1) == p11) {
					count1++;
					p1++;
				}
				
				while(p2 >= 0 && listB.get(p2) == p22) {
					count2++;
					p2--;
				}
				
				count += count1 * count2;
			}
			
			else if(p11 + p22 > T) p2--;
			else p1++;
		}
		
		System.out.println(count);
		
	}

}
