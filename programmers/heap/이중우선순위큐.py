# 프로그래머스
# 이중우선순위큐
# https://programmers.co.kr/learn/courses/30/lessons/42628

# 21/10/03



import heapq

def solution(operations):    
    maxq = []
    minq = []
    count = 0
        
    for op in operations:
        if op[0] == 'I':
            heapq.heappush(maxq, -int(op[2:]))
            heapq.heappush(minq, int(op[2:]))
            count += 1
        
        elif op == 'D 1':
            if count > 0:
                heapq.heappop(maxq)
                minq.pop(len(minq)-1)
                count -= 1
        
        elif op == 'D -1':
            if count > 0:
                heapq.heappop(minq)
                maxq.pop(len(maxq)-1)
                count -=1
        
    if count > 0:
        return [-heapq.heappop(maxq), heapq.heappop(minq)]
    else:
        return [0,0]
