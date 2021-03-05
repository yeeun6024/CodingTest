import java.io.*;
import java.util.*;

class Info {
	int weight, height;
	
	Info(int weight, int height) {  // 클래스 이용
		this.weight = weight;
		this.height = height;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		ArrayList<Info> list = new ArrayList<>();
		int[] rank = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Info(w,h));
			rank[i] = 1;
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(list.get(i).weight < list.get(j).weight) {
					if(list.get(i).height < list.get(j).height) {
						rank[i]++;
					}
				}
				
				else if(list.get(i).weight > list.get(j).weight) {
					if(list.get(i).height > list.get(j).height) {
						rank[j]++;
					}
				}
			}
		}
		
		
		for(int x : rank) {
			System.out.print(x+" ");
		}

	}

}
