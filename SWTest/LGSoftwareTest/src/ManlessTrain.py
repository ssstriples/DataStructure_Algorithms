N, M = map(int, input().split())
graph = [[] for _ in range(N)]

l1 = []     # (r,c) tuple 저장예정
l2 = []

for i in range(N):
    graph[i] = list(map(int, input().split()))

def checkBound(graph2, i, j):
    if 0 <= i < N and 0 <= j < M:
        return True
    return False
    
di = [-1, 1, 0, 0] # 상, 하, 좌, 우
dj = [0, 0, -1, 1]

def dfs(li, graph3, i, j):
    if checkBound(graph3, i, j):
        if graph3[i][j]:
            li.append((i, j))
            graph3[i][j] = 0
            
            for x in range(4):
                dfs(li, graph3, i+di[x], j+dj[x])
        else:
            return

def makeGroup(li, gr):
    for i in range(N):
        for j in range(M):
            if gr[i][j]:
                dfs(li, gr, i, j)
                return

gr = graph.copy()
makeGroup(l1, gr)
makeGroup(l2, gr)

# print(l1)
# print(l2)

min = int(1e9)
for i in range(len(l1)):
    si, sj = l1[i]
    for j in range(len(l2)):
        ei, ej = l2[j]
        sol = abs(si - ei) + abs(sj - ej) - 1
        if min > sol:
            min = sol
print(min)
    