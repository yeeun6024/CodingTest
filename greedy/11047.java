import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 입력받기 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();	// 동전의 개수
		int k = s.nextInt();	// 동전의 합. k원
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i] = s.nextInt();
		}
		
		
		/* 최소값 계산 */
		int min = 0;	// 필요한 동전 개수의 최소값
		int len = coin.length-1;
		
		while(k>0) {
			if(k < coin[len]) {
				len--;
			}
			else {
				min += k / coin[len];
				k %= coin[len];
			}
		}
		
		
		/* 최소값 출력 */
		System.out.println(min);		

	}

}
