# 예산
# https://programmers.co.kr/learn/courses/30/lessons/12982

# 데이터를 먼저 정렬한 뒤
# 가장 작은 수들을 먼저 더하고
# budget보다 넘어가면 그 전 개수를 리턴하는 방식

def solution(d, budget):    
    d.sort()
    
    tot = 0
    for i in range(len(d)):
        tot += d[i]
        if tot > budget:
            return i
        
    return len(d)
