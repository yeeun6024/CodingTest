import java.util.*;

public class Main {
	
	static int n;
	static boolean[] visited;
	static int[] arr;
	
	static void dfs(int depth) {
		if(depth == n) {
			for(int x : arr) 
				System.out.print(x+" ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1];
		arr = new int[n];
		
		dfs(0);

	}

}
