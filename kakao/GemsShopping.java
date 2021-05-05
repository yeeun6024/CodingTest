/**
 *
 *  2020 카카오 인턴십 : 보석쇼핑
 *
 */

import java.util.*;

class Solution {
    
    static Queue<String> queue = new LinkedList<>();
    static HashSet<String> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static int startPoint = 0;
    static int length = Integer.MAX_VALUE;
    
    public int[] solution(String[] gems) {
        for(String str : gems){
            set.add(str);   // 셋에 추가. 겹치지 않음. 각각의 보석만 들어감.
        }
        
        int start = 0;
        for(int i=0; i<gems.length; i++) {
            if(!map.containsKey(gems[i])) map.put(gems[i],1); // 없으면 1
            else map.put(gems[i],map.get(gems[i])+1); // 있으면 +1
            
            queue.add(gems[i]); // 큐에 삽입
            
            while(true) {
                String temp = queue.peek(); // 완전히 제거 아니고 그냥 첫번째거 정보만
                if(map.get(temp)>1) {   // 1보다 크면(여러개 있다는 의미)
                    map.put(temp, map.get(temp)-1); // -1해주고
                    queue.poll();   // 맨 앞에꺼 제거
                    startPoint++;   // 시작점 +1
                }
                else    // 1보다 크지 않으면 다음.
                    break;
            }
            
            if(map.size()==set.size() && length>queue.size()) {
                // 큐가 모든 보석을 가지고 있고, 새로운 구간 길이가 기존의 구간길이보다 작다면
                length = queue.size();
                start = startPoint;
            }
        }
        
        return new int[] {start+1, start+length};
        
    }
}
