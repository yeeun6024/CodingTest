import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static int count = 0;
	
	static void dfs(int row) { // 깊이 우선 탐색
		if(row == n) {	// 마지막 줄까지 갔으면 종료
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[row] = i;
			
			if(isOk(row)) // 놓을 수 있는 위치일 경우 다음 줄로 넘어감.
				dfs(row+1);
		}
	}
	
	static boolean isOk(int row) { // 백트래킹
		for(int i=0; i<row; i++) {
			if(arr[row] == arr[i]) // 같은 열에 있는 경우
				return false;
			else if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])) // 대각선에 있는 경우
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		arr = new int[n];
		
		dfs(0);
		
		System.out.println(count);

	}

}
