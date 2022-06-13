# 달팽이는 올라가고 싶다.
# https://www.acmicpc.net/problem/2869


a, b, v = map(int, input().split())
cnt = 1
v -= a  # 마지막에 올라가는 높이

cnt += (v // (a-b)) if v % (a-b)==0 else (v // (a-b)) + 1  # 올라가고 떨어지는 거리 차이가 남은 거리에 나눠 떨어지면 +0 아니면 +1

print(cnt)
