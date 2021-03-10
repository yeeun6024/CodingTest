import java.util.*;

public class Ex_14888 {
	
	static int n;
	static int[] arr;
	static int[] operator;
	static int min = 1000000000;
	static int max = -1000000000;
	
	static void dfs(int num, int index) {
		
		if(index==n) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				
				operator[i]--; // 하나 이용했으니까 빼준다.
				
				switch(i) {
				case 0 : dfs(num + arr[index], index+1); break;
				case 1 : dfs(num - arr[index], index+1); break;
				case 2 : dfs(num * arr[index], index+1); break;
				case 3 : dfs(num / arr[index], index+1); break;
				}
				
				operator[i]++;	// 끝까지 다 연산을 하고 나서 다시 더해준다. 원상복귀.
			}
		}
		
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		arr = new int[n];
		operator = new int[4];
		
		for(int i=0; i<n; i++) {	// 숫자 입력
			arr[i] = s.nextInt();
		}
		
		for(int i=0; i<4; i++) {	// 연산자 입력
			operator[i] = s.nextInt();
		}
		
		dfs(arr[0], 1);
		
		System.out.println(max+"\n"+min);

	}

}
