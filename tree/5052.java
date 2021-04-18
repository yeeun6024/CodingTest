import java.io.*;
import java.util.Arrays;

public class Main {
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t>0) {
			int n = Integer.parseInt(br.readLine());
			String[] array = new String[n];
			boolean check = false;
			for(int i=0; i<n; i++) {
				array[i] = br.readLine();
			}
			
			Arrays.sort(array);
			
			for(int i=0; i<n-1; i++) {
				String cur = array[i];
				String next = array[i+1];
				
				if(cur.length() < next.length()) {
					if(next.indexOf(cur)==0) { // startWith 써도 가능
						check = true;
						break;
					}
				}
			}
			
			if(check) sb.append("NO\n");
			else sb.append("YES\n");
			t--;
		}
		
		System.out.println(sb);

	}

}
