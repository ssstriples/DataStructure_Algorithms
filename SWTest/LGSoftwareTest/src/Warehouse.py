INF = int(1e9)

N, M = map(int, input().split())

graph = [[INF] * (N + 1) for _ in range(N + 1)]

for a in range(1, N + 1):
    for b in range(1, N + 1):
        if a == b:
            graph[a][b] = 0

for _ in range(M):
    a, b ,c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c # 양방향

# 플로이드 워셜 알고리즘
for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

maxlist = []
max = 0
for a in range(1, N + 1):
    for b in range(1, N + 1):
        if max < graph[a][b]:
            max = graph[a][b]
    maxlist.append(max)
    max = 0

print(min(maxlist))