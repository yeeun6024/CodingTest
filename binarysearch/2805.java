import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[n];
		for(int i=0; i<n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/* 정렬 */
		Arrays.sort(tree);
	
		
		/* 계산과 출력 */
		int low = 1;
		int high = tree[n-1];
		int mid;
		long sum = 0;
		
		while(low <= high) {
			sum = 0;
			mid = (low + high) / 2;
			
			for(int i=0; i<n; i++) {
				if(tree[i] >= mid) {
					sum += (tree[i] - mid);
				}
			}
			
			if(sum >= m) low = mid + 1;
			else high = mid - 1;
		}
		
		System.out.println(high);
		
	}

}
