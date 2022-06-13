# 수 정렬하기 2
# https://www.acmicpc.net/problem/2751


import sys

n = int(input())
num = []

for i in range(n):
    num.append(int(sys.stdin.readline())) # 입력은 input()보다 이게 빠름

num.sort()  # sort()는 O(nlogn)

for i in num:
    sys.stdout.write(str(i)+'\n') # 출력도
