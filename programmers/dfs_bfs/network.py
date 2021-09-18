# 프로그래머스
# 네트워크
# https://programmers.co.kr/learn/courses/30/lessons/43162?language=python3

# 21/09/15


def solution(n, computers):
    answer = 0
    visited = []
    queue = []

    for index in range(n):
        if(index not in visited):
            queue.append(index)
            
            while len(queue) > 0 :
                loc = queue.pop()

                if(loc not in visited):
                    visited.append(loc)

                    for i in range(n):
                        if(computers[loc][i]==1 and i not in visited):
                            queue.append(i)
            
            answer = answer + 1
        
    return answer
