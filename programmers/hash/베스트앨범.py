# 프로그래머스
# 베스트 앨범
# https://programmers.co.kr/learn/courses/30/lessons/42579

# 21/09/26


def solution(genres, plays):
    answer = []
    
    play_sum = {}
    dic = {}
    idx = 0
    
    for i in range(len(genres)):
        if genres[i] not in play_sum:
            play_sum[genres[i]] = plays[i]
        else:
            play_sum[genres[i]] += plays[i]
            
        dic[idx] = [genres[i],plays[i]]
        idx += 1

            
    sorted_play = sorted(play_sum.items(), key = lambda item:item[1], reverse=True)
    sorteddic = sorted(dic.items(), key = lambda item:item[1][1], reverse=True)
    
    for gen in sorted_play:
        idx = 0
        for item in sorteddic:
            if item[1][0] == gen[0]:
                answer.append(item[0])
                idx += 1
            
            if idx == 2 : break
    
    return answer
