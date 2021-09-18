// 프로그래머스
// 단어변환
// https://programmers.co.kr/learn/courses/30/lessons/43163?language=python3#
  
// 21/09/17

answer = 50

def solution(begin, target, words):
    global answer
    
    dfs(begin, target, words, len(words))
    
    if(answer == 50):
        answer = 0
    
    return answer

def dfs(begin, target, words, length):
    global answer
    
    if(begin==target):
        if(answer > length-len(words)):
            answer = length-len(words)
            return
    
    if(len(words)==0):
        return
    
    for word in words:
        count = 0
        for i in range(len(word)):
            if begin[i]==word[i]: 
                count += 1
            
        if(count >= len(word)-1):
            words.remove(word)
            dfs(word, target, words, length)
            words.append(word)
