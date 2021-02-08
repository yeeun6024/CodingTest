import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		long[] count = new long[n+1];
		
		
		/* 횟수 계산 */
		count[1] = 1;
		if(n>=2) count[2] = 1;
		
		for(int i=3; i<count.length; i++) {
			count[i] = count[i-2] + count[i-1];
		}
		
		
		/* 출력 */
		System.out.println(count[n]);

	}

}
