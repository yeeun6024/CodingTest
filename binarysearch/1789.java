import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long s = Long.parseLong(br.readLine());
		

		/* 계산 */
		long sum = 0;
		long count = 0;
		
		while(sum <= s) {	// s가 될 때까지 1부터 계속 더해준다.
			count++;
			sum += count;
		}
		
		if(sum > s) count--;	// s보다 커졌을 때 그만큼의 수 하나를 빼주면 됨. 그래서 count--;
		
		
		/* 출력 */
		System.out.println(count);
		

	}

}
