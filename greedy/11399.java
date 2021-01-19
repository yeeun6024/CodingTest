import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 입력 받기 */
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();	// 사람의 수
		int[] time = new int[n];	// 인출하는데 걸리는 시간 배열
		
		for(int i=0; i<n; i++) {
			time[i] = s.nextInt();
		}
		
		
		/* 정렬 */
		for(int i=0; i<n; i++) {	// 삽입정렬
			for(int j=i+1; j<n; j++) {
				if(time[i] > time[j]) {
					int temp = time[j];
					time[j] = time[i];
					time[i] = temp;
				}
			}
		}
		
		
		/* 시간의 합 계산 */
		int sum = 0;
		int nn = n;
		
		for(int i=0; i<n; i++) {
			sum += time[i]*nn;
			nn--;
		}
		
		
		/* 출력 */
		System.out.println(sum);
		

	}

}
