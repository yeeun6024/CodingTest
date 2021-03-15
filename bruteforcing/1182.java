import java.util.*;

public class Main {
	
	static int n, s;
	static int[] arr;
	static int count = 0;
	
	static void dfs(int depth, int sum) {
		if(depth == n) {
			if(sum == s) {
				count++;
			}
			return;
		}
		
		dfs(depth+1, sum);
		dfs(depth+1, sum+arr[depth]);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0,0);
		
		if(s==0) count--;
		
		System.out.println(count);

	}

}
