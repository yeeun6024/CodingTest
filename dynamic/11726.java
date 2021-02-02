import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int[] count = new int[x+1];
		
		count[0] = 1;
		count[1] = 1;
				
		/* 직사각형 개수 계산 */
		if(x>=2) {
			for(int i=2; i<count.length; i++) {
				count[i] = (count[i-1] + count[i-2]) % 10007; // 왜 여기다가 해주는거지 왜지
			}
		}
		
		/* 출력 */
		System.out.println(count[x]);
		
	}

}
