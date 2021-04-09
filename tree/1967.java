import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Node>[] list;
	static int leftMax = 0;
	static int rightMax = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		int max = 0;
		boolean left = true;
		
		for(int i=1; i<=n; i++) {
			if(list[i].size()==0) continue;
			
			int sum = 0;
			leftMax = rightMax = 0;
			for(Node n : list[i]) {
				sum += n.weight;
				dfs(n,0,left);
				
				if(left) left = false;
				else left = true;
			}
			
			sum += leftMax + rightMax;
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
	

	
	static void dfs(Node node, int sum, boolean left) {
		if(list[node.next].size()==0) {
			if(left) {
				leftMax = Math.max(leftMax, sum);
			}
			else {
				rightMax = Math.max(rightMax, sum);
			}
			
			return;
		}
		
		for(Node n : list[node.next]) {
			sum += n.weight;
			dfs(n,sum,left);
			sum -= n.weight;
		}
				
	}
	
	static class Node {
		int next, weight;
		
		Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}

}
