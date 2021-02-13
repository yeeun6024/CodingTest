import java.io.*;
import java.util.*;

public class Main {
	
	static int[] A;
	
	static int lowerBound(int x) {
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while(start < end) {
			mid = (start + end) / 2;
			if(A[mid] >= x) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	static int upperBound(int x) {
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while(start < end) {
			mid = (start + end) / 2;
			if(A[mid] > x) end = mid;
			else start = mid + 1;
		}
		if(A[end] == x) end++;
		
		return end;
	}
	

	public static void main(String[] args) throws IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/* 정렬 */
		Arrays.sort(A);
		
		
		/* 계산 및 출력 */
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int result = upperBound(x) - lowerBound(x);
			sb.append(result + " ");
		}
		
		System.out.println(sb);
		
	}

}
