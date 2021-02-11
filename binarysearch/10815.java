import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static long[] A;
	
	static int check(int x) {
		int start = 0;
		int end = n-1;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(A[mid] == x) return 1;
			else if(A[mid] < x) start = mid + 1;
			else end = mid-1;
		}
		
		return 0;
	}

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		A = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		long[] B = new long[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		} 
		
		
		/* 정렬 */
		Arrays.sort(A);
		
		
		/* 출력 */
		for(int b : B) {
			System.out.print(check(b) + " ");
		}
	}
}
