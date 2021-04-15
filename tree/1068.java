import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int count = 0;
	static int remNode;
	static int root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		String[] str = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(str[i]);
			if(x==-1) {
				root = i;	// 루트가 항상 0이라는 말 없음
				continue;
			}
			
			list[x].add(i);
		}
		
		remNode = Integer.parseInt(br.readLine());
		
		if(remNode==root) System.out.println(0);
		else {
			dfs(root);
			System.out.println(count);
		}

	}
	
	static void dfs(int index) {
		// 자식노드가 1개인데 그 자식이 remNode일 경우를 생각해주어야함.
		// 자식노드가 없으면 무조건 카운트해야하지만, 위인 경우도 고려해야한다.
		int countChild = list[index].size();
		
		for(int x : list[index]) {
			if(x != remNode) dfs(x);
			else countChild--;
		}
		
		if(countChild==0) {
			count++;
			return;
		}
	}
}
