// 프로그래머스
// 완주하지 못한 선수
// https://programmers.co.kr/learn/courses/30/lessons/42576
  
// 21/09/26


def solution(participant, completion):

    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if(participant[i] != completion[i]):
            return participant[i]

    return participant[len(participant)-1]
