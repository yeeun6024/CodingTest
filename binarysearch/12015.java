import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0);	// 1보다 작은 0을 넣어준다.
		
		for(int i=0; i<n; i++) {
			int x = s.nextInt();
			
			if(list.get(list.size()-1) < x) {	// 리스트의 마지막 수보다 크면 추가
				list.add(x);
			}
			else {	// 리스트의 마지막 수보다 작다면 x가 들어갈 자리를 찾는다.
				int start = 0;
				int end = list.size() - 1;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(list.get(mid) >= x)	end = mid;
					else start = mid + 1;
				}
				
				list.set(end, x);	// 대체
			}
			
		}
	
		
		/* 출력 */
		System.out.println(list.size() - 1);

	}

}
