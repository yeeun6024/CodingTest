import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> height = new ArrayList<>();
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			int x = Integer.parseInt(br.readLine());
			height.add(x);
			sum += x;
		}
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(height.get(i) + height.get(j) == sum - 100) {
					height.remove(j);
					height.remove(i);
					break;
				}
					
			}
			
			if(height.size() == 7) break;
		}
		
		Collections.sort(height);
		
		for(int x : height) {
			System.out.println(x);
			
		}

	}

}
