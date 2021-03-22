# DP 최적화
N = int(input())
P = list(map(int, input().split()))

sum = P[0]

for i in range(1, N):
    if P[i-1] < P[i]:
        sum = sum - P[i-1] + P[i]

print(sum)