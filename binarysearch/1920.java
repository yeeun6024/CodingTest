import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] A;
	
	static int binSearch(int x) {
		
		int start = 0;
		int end = n-1;
		int mid;
		int key = x;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(A[mid] == key) return 1;
			else if(A[mid] > key) end = mid-1;
			else start = mid + 1;
		}
		
		return 0;
	}

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] x = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/* 정렬 */
		Arrays.sort(A);

		
		/* 출력 */
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		for(int a : x)
			bw.write(s + binSearch(a)+"\n");
		bw.flush();
		bw.close();

	}

}
