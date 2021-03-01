import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 입력 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 0;
		
		/* 한수 개수 계산 */
		for(int i=1; i<=n; i++) {
			String str = "" + i;
			
			if(str.length() == 1 || str.length() == 2) count++;	// 한자리, 두자리일 경우는 무조건 카운트
			else if(str.length() == 3) {	// 세자리는 각 자리의 차를 비교한다.
				if((int)str.charAt(0)-(int)str.charAt(1) == (int)str.charAt(1)-(int)str.charAt(2))
					count++;
			}
		}
		
		System.out.println(count);
		
	}

}
