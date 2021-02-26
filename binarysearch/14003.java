import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> list = new ArrayList<>();	// 길이를 위한 리스트
		
		int[] number = new int[n];	// 입력받은 수 담는 배열
		int[] loc = new int[n];		// 수의 위치 담는 배열
		
		list.add(Integer.MIN_VALUE);	// 최소값을 미리 넣어준다.
		
		/* 길이와 위치 계산 */
		for(int i=0; i<n; i++) {
			int x = s.nextInt();
			number[i] = x;
			
			if(list.get(list.size()-1) < x)  {
				list.add(x);
				loc[i] = list.size() - 1; 
			}
			else {
				int start = 0;
				int end = list.size() - 1;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(list.get(mid) >= x) end = mid;
					else start = mid + 1;
				}
				
				list.set(end, x);
				loc[i] = end;
			}
		}
		
		/* 역추적 */
		Stack<Integer> stack = new Stack<>();
		int index = list.size() - 1;
		for(int i=n-1; i>=0; i--) {		// 위치에 해당하는 숫자를 거꾸로 스택에 삽입
			if(index == loc[i]) {
				stack.push(number[i]);
				index--;
			}
		}
		
		/* 출력 */
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()-1 + "\n");
		
		while(!stack.isEmpty()) {	// 거꾸로 넣어 놓은 숫자를 하나씩 꺼낸다.
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb);

	}

}
