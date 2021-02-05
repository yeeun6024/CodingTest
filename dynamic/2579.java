import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n+1];
		int[] max = new int[n+1];
		
		for(int i=1; i<score.length; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		
		/* 합계 계산 */
		max[1] = score[1];
		
		if(n >= 2)	max[2] = score[1] + score[2];
		
		for(int i=3; i<score.length; i++) {
			max[i] = Math.max(max[i-2], max[i-3]+score[i-1]) + score[i];
		}
		
		
		/* 출력 */
		System.out.println(max[n]);

	}

}
