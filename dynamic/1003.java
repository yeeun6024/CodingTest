import java.io.*;

public class Main {
	
	static int[][] fib;
	
	static void fibonacci() {
		
		fib[0][0] = 1;
		fib[1][1] = 1;
		
		for(int i=2; i<fib.length; i++) {
			for(int j=0; j<2; j++) {
				fib[i][j] = fib[i-1][j] + fib[i-2][j];
			}
		}

	}

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		fib = new int[41][2];	// 횟수 배열

		
		/* 피보나치 함수 호출 */
		fibonacci();
		
		
		/* 횟수 출력 */
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(fib[x][0]+ " "+ fib[x][1]+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
