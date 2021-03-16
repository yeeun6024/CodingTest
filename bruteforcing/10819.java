import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static boolean[] visited;
	static int max = 0;
	
	static void dfs(int depth, int before, int sum) {
		if(depth==n-1) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				sum += Math.abs(arr[before]-arr[i]);
				visited[i] = true;
				dfs(depth+1, i, sum);
				sum -= Math.abs(arr[before]-arr[i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			visited[i] = true;
			dfs(0,i,0);
			visited[i] = false;			
		}
		
		System.out.println(max);
		
	}

}
