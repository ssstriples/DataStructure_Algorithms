# 도로건설
# 아이디어1 : 다익스트라
# import heapq
# import sys
# input = sys.stdin.readline
# INF = int(1e9)

# # 지도 크기 N (2 ~ 100)
# N = int(input())
# # 토지 가격 정보 입력 받기
# A = [[0] * N for _ in range(N)]
# for i in range(N):
#     A[i] = list(input())

# graph = [[] for i in range((N**2) + 1)]
# distance = [INF] * ((N**2) + 1)


# def checkAdjNode(i, j):
#     flag = True
#     if i < 0 or i >= N or j < 0 or j >= N:
#         flag = False
#     return flag

# dx = [1, 0, 0, -1]
# dy = [0, 1, -1, 0]

# for i in range(N):
#     for j in range(N):
#         nodeNum = N * i + j + 1
#         for k in range(4):
#             x = j + dx[k]
#             y = i + dy[k]
#             if checkAdjNode(y, x):
#                 adjNodeNum = N * y + x + 1
#                 graph[nodeNum].append((adjNodeNum, int(A[y][x])))
# # print(graph)

# def dijkstra(start):
#     q = []
#     heapq.heappush(q, (0, start))
#     distance[start] = 0

#     while q:
#         dist, now = heapq.heappop(q)
#         # 현재 노드가 이미 처리된 적이 있으면 무시
#         if distance[now] < dist:
#             continue
#         # 인접 노드 확인
#         for i in graph[now]:
#             cost = dist + i[1]
#             # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
#             if cost < distance[i[0]]:
#                 distance[i[0]] = cost
#                 heapq.heappush(q, (cost, i[0]))
# dijkstra(1)
# print(distance[N*N])

# 아이디어2 : BFS
from collections import deque
INF = int(1e9)

# 지도 크기 N (2 ~ 100)
N = int(input())
# 토지 가격 정보 입력 받기
graph = []
for i in range(N):
    graph.append(list(map(int, input())))


# 상, 하, 좌, 우 방향 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문 여부
visited = [[INF] * N for _ in range(N)]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = graph[x][y]
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            
            if visited[nx][ny] > visited[x][y] + graph[nx][ny]:
                visited[nx][ny] = visited[x][y] + graph[nx][ny]
                queue.append((nx, ny))

    # print(visited)
    return visited[N-1][N-1]
    
print(bfs(0, 0))