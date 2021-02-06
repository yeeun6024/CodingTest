import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] fib = new long[n+1];
		
		
		/* 피보나치 계산 */
		fib[0] = 0;
		fib[1] = 1;
		
		if(n>=2) {
			for(int i=2; i<fib.length; i++) {
				fib[i] = fib[i-1] + fib[i-2];
			}
		}
		
		
		/* 출력 */
		System.out.println(fib[n]);
		
	}

}
