import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		int[] time = new int[100001];
		
		
		/* 너비 우선 탐색 */
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		time[n]=1;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if(x==k) break;
			
			if(x-1>=0 && time[x-1]==0) {
				queue.offer(x-1);
				time[x-1] = time[x] + 1;
			}
			
			if(x+1<=100000 && time[x+1]==0) {
				queue.offer(x+1);
				time[x+1] = time[x] + 1;
			}
			
			if(x*2<=100000 && time[x*2]==0) {
				queue.offer(x*2);
				time[x*2] = time[x] + 1;
			}
			
		}
		
		
		/* 출력 */
		System.out.println(time[k]-1);

	}

}
