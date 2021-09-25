# 프로그래머스
# 위장
# https://programmers.co.kr/learn/courses/30/lessons/42578

# 21/09/26


def solution(clothes):
    answer = 1
    
    count = dict()
    
    for cloth in clothes:
        if cloth[1] in count:
            count[cloth[1]] = count[cloth[1]] + 1
        else:
            count[cloth[1]] = 1
            
    for i in count.values():
        answer = answer * (i+1)
    
    return answer-1
