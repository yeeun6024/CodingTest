import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 듣도 못한 사람 수
		int m = Integer.parseInt(st.nextToken());	// 보도 못한 사람 수
		HashSet<String> hs = new HashSet<>();		// 듣도 못한 사람 담을 해시셋
		ArrayList<String> list = new ArrayList<>();	// 듣도 보도 못한 사람 담을 리스트
		
		for(int i=0; i<n; i++) {
			hs.add(br.readLine());
		}
		
		
		/* 포함 여부 확인 */
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			if(hs.contains(s)) list.add(s);	// 보도 못한 사람의 이름이 해시셋에 있으면 리스트에 추가
		}
		
		
		/* 정렬 */
		Collections.sort(list);		// 리스트 정렬
		
		
		/* 출력 */
		System.out.println(list.size());
		for(String s : list) 
			System.out.println(s);
	}

}
