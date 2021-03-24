import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0);
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			
			if(list.get(list.size()-1) < x)
				list.add(x);
			else {	// 이분탐색
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
		
		System.out.println(n-list.size()+1);
		

	}

}
