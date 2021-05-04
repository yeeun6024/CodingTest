/**
 * 2020 카카오 인턴십 : 수식 최대화
 * 기본적인 것부터 다틀림;;;
 */

import java.util.*;

class Solution {
    
    static char[] operator = {'+','-','*'};
    static boolean[] use = new boolean[3];
    static char[] tempOp = new char[3];
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<Character> opList = new ArrayList<>();
    static long answer = 0;
    
    public long solution(String expression) {
       
        String number = "";
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) >='0' && expression.charAt(i)<='9') {   // 숫자면 number에
                number += expression.charAt(i);
            }
            else {  // 숫자가 아니면 연산기호일테니까 앞에 숫자를 numList에 넣고, 연산자를 opList에
                numList.add(Long.parseLong(number));
                opList.add(expression.charAt(i));
                number="";
            }
        }
        
        numList.add(Long.parseLong(number));    // 마지막 숫자는 안들어갔으니까 따로 넣어주어야함.
      
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int depth) {
        if(depth==3) {  // 기호는 세개밖에 없으니까 세개의 순서를 다 정하면 계산
            calc();
        }
        else{
            for(int i=0; i<3; i++) {
                if(!use[i]) {   // 기호의 우선순위를 정해준다.
                    use[i] = true;
                    tempOp[depth] = operator[i];
                    dfs(depth+1);
                    use[i] = false;
                }
            }
        }
    }
    
    public void calc() {
        ArrayList<Long> cNumList = new ArrayList<>(numList);    // 원래 데이터가 망가지지 않도록 깊은 복사 필요
        ArrayList<Character> cOpList = new ArrayList<>(opList);
        
        for(char c : tempOp) {
            for(int i=0; i<cOpList.size(); i++) {
                if(c==cOpList.get(i)){
                    long res = calcOp(cNumList.remove(i), cNumList.remove(i),c);    // remove의 리턴값은 리스트의 자료형
                    cNumList.add(i,res);
                    cOpList.remove(i);
                    i--;    // i번째 제거했으니까 하나 줄여줘야함.
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(cNumList.get(0)));
    }
    
    public long calcOp(long x, long y, char op) {
        switch(op) {
            case '+' : return x+y;
            case '-' : return x-y;
            case '*' : return x*y;
        }
        
        return (long)0;
        
    }
}
