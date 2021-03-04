import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			String str = "" + i;
			sum = i;
			for(int j=0; j<str.length(); j++) {
				sum += Integer.parseInt(str.charAt(j) + ""); 
			}
			
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);

	}

}
