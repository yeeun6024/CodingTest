# 프로그래머스
# 여행경로
# https://programmers.co.kr/learn/courses/30/lessons/43164

# 21/09/18


answer = []

def solution(tickets):
    global answer

    dfs(tickets, 'ICN', ['ICN'])

    return answer


def dfs (tickets, target, ans):
    global answer

    if len(tickets) == 0 : 
        if(len(answer)==0 or ans < answer):
            answer = list(ans)
        return

    temp = list(tickets)

    for ticket in tickets:
        if ticket[0] == target :
            ans.append(ticket[1])
            temp.remove(ticket)
            dfs(temp, ticket[1], ans)
            ans.pop()
            temp.append(ticket)
