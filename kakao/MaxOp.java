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
            if(expression.charAt(i) >='0' && expression.charAt(i)<='9') {
                number += expression.charAt(i);
            }
            else {
                numList.add(Long.parseLong(number));
                opList.add(expression.charAt(i));
                number="";
            }
        }
        
        numList.add(Long.parseLong(number));
      
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int depth) {
        if(depth==3) {
            calc();
        }
        else{
            for(int i=0; i<3; i++) {
                if(!use[i]) {
                    use[i] = true;
                    tempOp[depth] = operator[i];
                    dfs(depth+1);
                    use[i] = false;
                }
            }
        }
    }
    
    public void calc() {
        ArrayList<Long> cNumList = new ArrayList<>(numList);
        ArrayList<Character> cOpList = new ArrayList<>(opList);
        
        for(char c : tempOp) {
            for(int i=0; i<cOpList.size(); i++) {
                if(c==cOpList.get(i)){
                    long res = calcOp(cNumList.remove(i), cNumList.remove(i),c);
                    cNumList.add(i,res);
                    cOpList.remove(i);
                    i--;
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
