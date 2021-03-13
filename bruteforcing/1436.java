import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int number = 666;
		int count = 1;
		
		while(n>=2) {
			number++;
			
			String num = ""+number;
			if(num.contains("666"))
				count++;
			
			if(count == n) break;
		}
		
		System.out.println(number);

	}

}
