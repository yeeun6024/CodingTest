import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] info = new int[n][2];   // 배열 
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<n; i++) {
			int rank = 1;
			
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				
				if(info[i][0] < info[j][0] && info[i][1] < info[j][1])
					rank++;
			}
			
			System.out.print(rank + " ");
		}

	}

}
