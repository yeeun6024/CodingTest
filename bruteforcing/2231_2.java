import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int n = Integer.parseInt(str);
		int sum = 0;
		
		for(int i=n-9*(str.length()); i<=n; i++) {
			int number = i;
			sum = i;
			
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);

	}

}

// 얘가 메모리 훨씬줄고 시간도 훨씬 줄음.
