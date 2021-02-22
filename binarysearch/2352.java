import java.io.*;
import java.util.*;

public class Main {	// 12015와 비슷한 문제

	public static void main(String[] args) throws IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list =new ArrayList<>();
		String number = br.readLine();
		StringTokenizer st = new StringTokenizer(number);
		list.add(0);

		/* 리스트에 추가 */
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());	// 토큰을 받아서
			if(list.get(list.size()-1) < x) list.add(x);	// 앞에 수보다 크면 넣음.
			else {	// 앞에 수보다 크지 않으면 순서에 맞게 대체
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
