# 프로그래머스
# 더 맵게
# https://programmers.co.kr/learn/courses/30/lessons/42626?language=python3

# 21/10/03

import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while True:
        if scoville[0] >= K or len(scoville)==1:
            break
        
        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        new = a + b * 2
        heapq.heappush(scoville, new)
        answer += 1
        
    if scoville[0] < K:
        answer = -1

    return answer
