import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		/* 입력 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] list = new int[n];
		
		for(int i=0; i<n; i++) {
			list[i] = s.nextInt();
		}
		
		
		/* 최대값 찾기 */
		int max = list[0];
		for(int i=1; i<n; i++) {
			if(list[i] > max)
				max = list[i];
		}
		
		
		/* 1,2,3의 합으로 나타내는 방법의 수 찾기 */
		int[] result = new int[max+1];
		result[1] = 1;
		result[2] = 2;
		result[3] = 4;
		
		for(int i=4; i<result.length; i++) {
			result[i] = result[i-1] + result[i-2] + result[i-3];
		}
		
		
		/* 출력 */
		for(int x : list)
			System.out.println(result[x]);
		
	}

}
