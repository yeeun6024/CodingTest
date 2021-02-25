import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);	// 가장 작은 수 넣어줌. 0아님!!
		
		/* 긴 수열 찾아내는 방법 */
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(list.get(list.size()-1) < x) list.add(x);
			else {
				int start = 0;
				int end = list.size() - 1;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(list.get(mid) >= x) end = mid;
					else start = mid + 1;
				}
				
				list.set(end, x);
			}

		}
		
		/* 출력 */
		System.out.println(list.size() - 1);

	}

}
