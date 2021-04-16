/* 실패 */

import java.io.*;

public class Main {
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] list = new String[n];
			for(int j=0; j<n; j++) {
				list[j] = br.readLine();
			}
			check(list);
		}
		
		System.out.println(sb);

	}
	
	static void check(String[] list) {
		
		for(int i=0; i<list.length-1; i++) {
			for(int j=i+1; j<list.length; j++) {
				if(list[i].length() < list[j].length()) {
					if(list[j].substring(0, list[i].length()).equals(list[i])) {
						sb.append("NO\n");
						return;
					}
				}
				else {
					if(list[i].substring(0, list[j].length()).equals(list[j])) {
						sb.append("NO\n");
						return;
					}
				}
			}
		}
		
		sb.append("YES\n");
		
	}

}
