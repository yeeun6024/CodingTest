import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(!map.containsKey(x))
				map.put(x, 1);
			else 
				map.replace(x, map.get(x) + 1);
		}
		
		
		/* 포함 여부 확인 */
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(map.containsKey(x)) {
				sb.append(map.get(x)+" ");
			}
			else
				sb.append("0 ");
		}
		
		
		/* 출력 */
		System.out.println(sb.toString());
	}

}
