import sys
from collections import deque
sys.setrecursionlimit(10**4)
read = sys.stdin.readline

INF = 987654321
dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]
N, M = map(int, read().split())
board = []

for _ in range(N):
    board.append(list(map(int, read().split())))

def dfs(i, j):
    board[i][j] = 2
    for di, dj in dir:
        ni, nj = i + di, j + dj
        if 0 <= ni < N and 0 <= nj < M and board[ni][nj] == 1:
            dfs(ni, nj)

def bfs(si, sj):
    dist = [[INF for _ in range(M)] for _ in range(N)]
    dist[si][sj] = 0
    queue = deque()
    queue.append([si, sj])
    
    while queue:
        i, j = queue.popleft()
        if board[i][j] == 1:
            return dist[i][j]-1
        for di, dj in dir:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < M and board[ni][nj] != 2 and dist[ni][nj] > dist[i][j]+1:
                dist[ni][nj] = dist[i][j] + 1
                queue.append([ni, nj])
    return INF

flag = False
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            dfs(i, j)
            flag = True
            break
    if flag: break

ans = INF
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            ans = min(ans, bfs(i, j))

print(ans)
# 내 풀이
# N, M = map(int, input().split())
# graph = [[] for _ in range(N)]

# l1 = []     # (r,c) tuple 저장예정
# l2 = []

# for i in range(N):
#     graph[i] = list(map(int, input().split()))

# def checkBound(graph2, i, j):
#     if 0 <= i < N and 0 <= j < M:
#         return True
#     return False
    
# di = [-1, 1, 0, 0] # 상, 하, 좌, 우
# dj = [0, 0, -1, 1]

# def dfs(li, graph3, i, j):
#     if checkBound(graph3, i, j):
#         if graph3[i][j]:
#             li.append((i, j))
#             graph3[i][j] = 0
            
#             for x in range(4):
#                 dfs(li, graph3, i+di[x], j+dj[x])
#         else:
#             return

# def makeGroup(li, gr):
#     for i in range(N):
#         for j in range(M):
#             if gr[i][j]:
#                 dfs(li, gr, i, j)
#                 return

# gr = graph.copy()
# makeGroup(l1, gr)
# makeGroup(l2, gr)

# # print(l1)
# # print(l2)

# min = int(1e9)
# for i in range(len(l1)):
#     si, sj = l1[i]
#     for j in range(len(l2)):
#         ei, ej = l2[j]
#         sol = abs(si - ei) + abs(sj - ej) - 1 # 맨해튼 거리
#         if min > sol:
#             min = sol
# print(min)