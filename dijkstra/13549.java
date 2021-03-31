import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int max = 100001;
		
		int[] time = new int[max];
		boolean[] check = new boolean[max];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		time[n] = 0;
		check[n] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now==k) {
				System.out.println(time[now]);
				break;
			}
			
			if(now*2 < max && !check[now*2]) {
				queue.add(now*2);
				time[now*2] = time[now];
				check[now*2] = true;
			}
			
			if(now-1 >= 0 && !check[now-1]) {
				queue.add(now-1);
				time[now-1] = time[now] + 1;
				check[now-1] = true;
			}
			
			if(now+1 < max && !check[now+1]) {
				queue.add(now+1);
				time[now+1] = time[now] + 1;
				check[now+1] = true;
			}
						
		}
		

	}

}
