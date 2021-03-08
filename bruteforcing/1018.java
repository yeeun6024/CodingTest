import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		boolean[][] board = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = s.next();
			for(int j=0; j<m; j++) {
				if(str.charAt(j) == 'W')
					board[i][j] = true;		// W 일때 true
				else 
					board[i][j] = false;	// B일 때 false
			}
		}
		
		
		int startX = 0;
		int startY = 0;
		int min = n*m;
		while(startX+8<=n) {
			boolean c = board[startX][startY];
			int count = 0;
			
			for(int i=startX; i<startX+8; i++) {
				for(int j=startY; j<startY+8; j++) {
					if(board[i][j] != c) count++;
					c = !c;
				}
				c = !c;
			}
			
			count = Math.min(count, 64-count);
			
			if(min > count) 
				min = count;
			
			if(startY+8 < m) startY++;
			else {
				startY = 0;
				startX++;
			}
		}
		
		
		System.out.println(min);
		

	}

}
