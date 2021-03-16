INF = int(1e9)
N = int(input())
R = list()
P = list()
for _ in range(N):
    temp = list(map(int, input().split()))
    R.append(temp[0])
    P.append(temp[1])
mindiff = INF
mincnt = N

# 이진 Tree방식
# def dfs(n, cnt, mul, sum):
#     global mindiff, mincnt

#     if cnt != 0 :
#         diff = abs(mul - sum)
#         if mindiff > diff or ((mindiff == diff) and (mincnt > cnt)):
#             mindiff = diff
#             mincnt = cnt
    
#     if n >= N: return
    
#     dfs(n+1, cnt+1, mul*R[n], sum+P[n]) # 선택O
#     dfs(n+1, cnt, mul, sum) # 선택X

# 다중 Tree
def dfs(s, cnt, mul, sum):
    global mindiff, mincnt
    if cnt != 0:
        diff = abs(mul - sum)
        if mindiff > diff or ((mindiff == diff) and (mincnt > cnt)):
            mindiff = diff
            mincnt = cnt
    
    for i in range(s, N):
        dfs(i+1, cnt+1, mul*R[i], sum+P[i])

dfs(0, 0, 1, 0)
print(N-mincnt)