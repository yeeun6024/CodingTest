import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int k = s.nextInt();
		int n = s.nextInt();
		long[] line = new long[k];
		
		for(int i=0; i<k; i++) {
			line[i] = s.nextInt();
		}
		
		
		/* 정렬 */
		Arrays.sort(line);
		
		
		/* 계산 및 출력 */
		long start = 1;
		long end = line[k-1];
		long mid;
		long sum = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			
			for(int i=0; i<k; i++) {
				if(line[i] >= mid)
					sum += line[i] / mid;
			}
			
			if(sum >= n) start = mid + 1;
			else end = mid - 1;
		}
		
		System.out.println(end);
		
	}

}
