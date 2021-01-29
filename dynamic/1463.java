import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int[] count = new int[x+1];
		
		count[0] = 0;
		count[1] = 0;
		
		
		/* 1로 가는 과정 계산 */
		for(int i=2; i<=x; i++) {
			count[i] = 1+ count[i-1];
			
			if(i%3==0) count[i] = Math.min(1+ count[i/3], count[i]);
			if(i%2==0) count[i] = Math.min(1+ count[i/2], count[i]);
		}
		
		
		/* 출력 */
		System.out.println(count[x]);

	}

}
