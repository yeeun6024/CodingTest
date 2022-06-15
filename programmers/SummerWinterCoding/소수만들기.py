# 소수만들기
# https://programmers.co.kr/learn/courses/30/lessons/12977

import itertools

def primeNum(num):  # 소수 판별 함수
    for i in range(2,num):
        if num % i == 0:
            return False
        
    return True

  
def solution(nums):
    answer = 0

    li = list(itertools.combinations(nums,3))
    li = [sum(combi) for combi in li]
    
    for num in li:
        answer += 1 if primeNum(num) else 0
                
    return answer


