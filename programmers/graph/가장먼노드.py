# 프로그래머스
# 가장 긴 노드
# https://programmers.co.kr/learn/courses/30/lessons/49189

# 21/10/08

def solution(n, edge):
    answer = 0
    MAX = 50001
    count = [MAX]*(n+1)
    queue = []
    
    li = [[] for i in range(n+1)]
    print(li)
    
    for e in edge:
        li[e[0]].append(e[1])
        li[e[1]].append(e[0])
        
        
    count[1] = 1
    queue.append(1)
        
    while len(queue)!=0:
        loc = queue.pop(0)
        
        for i in li[loc]:
            if count[i] > count[loc] + 1:
                count[i] = count[loc] + 1
                queue.append(i)
                    
                    
    for i in count:
        if i == max(count[1:]):
            answer += 1
            
    return answer
