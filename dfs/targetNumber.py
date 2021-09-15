# 프로그래머스
# 타겟 넘버
# https://programmers.co.kr/learn/courses/30/lessons/43165?language=python3

#21/09/13


def solution(numbers, target):
    global answer
    answer = 0

    dfs(numbers, 0, 0+numbers[0], target)
    dfs(numbers, 0, 0-numbers[0], target)
    
    return answer


def dfs(numbers, index, result, target):
    global answer
    
    if(index==len(numbers)-1): 
        if(result==target):
            answer += 1
        return

    dfs(numbers, index+1, result+numbers[index+1], target)
    dfs(numbers, index+1, result-numbers[index+1], target)
