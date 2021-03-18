import java.io.*;
import java.util.*;

public class Ex_1759_2 {
	static int L, C;
	static char[] arr;
	static boolean[] use;
	static String str = "";
	
	static void dfs(int depth, String str) {
		if(str.length()==L) {
			if(check(str)) {
				System.out.println(str);
				return;
			}
		}
		
		if(depth==C) return;	// else if 하면 오류남;;
		
		dfs(depth+1, str+arr[depth]);
		dfs(depth+1, str);
		
	}
	
	static boolean check(String str) {
		int x = 0;	// 모음
		int y = 0;	// 자음
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
				x++;
			else y++;
		}
		
		if(x>=1 && y>=2) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		use = new boolean[C];
		
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		dfs(0, "");
		
	}

}
