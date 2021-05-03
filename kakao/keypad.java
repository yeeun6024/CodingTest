/**
 *
 * 2020 카카오 인턴 문제. 키패드 누르기
 *
 */


class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] leftHand = {3,0};
        int[] rightHand = {3,2};
        int[][] loc = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        
        for(int number : numbers) {
            if(loc[number][1]==0) { // 왼쪽 키패드
                leftHand = loc[number];
                answer+="L";
            }
            else if(loc[number][1]==2) {    // 오른쪽 키패드
                rightHand = loc[number];
                answer+="R";
            }
            else {  // 가운데 키패드
                int lenLeft = Math.abs(leftHand[0]-loc[number][0]) + Math.abs(leftHand[1]-loc[number][1]);
                int lenRight = Math.abs(rightHand[0]-loc[number][0]) + Math.abs(rightHand[1]-loc[number][1]);
                                
                if(lenLeft > lenRight)  {   // 오른손이 더 가까울 경우
                    answer += "R";
                    rightHand = loc[number];
                }
                else if(lenLeft < lenRight) {   // 왼손이 더 가까울 경우
                    answer += "L";
                    leftHand = loc[number];
                }
                else {  // 두 손 모두 같은 거리일 경우
                    if(hand.equals("left")) {   // 왼손잡이면 왼손
                        answer += "L";
                        leftHand = loc[number];
                    } 
                    else {  // 오른손잡이면 오른손
                        answer += "R";
                        rightHand = loc[number];
                    }
                }
            }
        }
        
        return answer;
    }
}
