# 색종이

# 정답 풀이
N = int(input())
A = [input() for _ in range(N)]
pos = dict()
base = "123456789"
for i in base:
    pos[i] = [10, 10, -1, -1]

for i in range(N):
    for j in range(N):
        if A[i][j] != '0':
            pos[A[i][j]][0] = min(pos[A[i][j]][0], i)
            pos[A[i][j]][1] = min(pos[A[i][j]][1], j)
            pos[A[i][j]][2] = max(pos[A[i][j]][2], i)
            pos[A[i][j]][3] = max(pos[A[i][j]][3], j)

B = [[0 for _ in range(N)] for _ in range(N)]
for b in base:
    y1, x1, y2, x2 = pos[b]
    for i in range(y1, y2 + 1):
        for j in range(x1, x2 + 1):
    	    B[i][j] += 1

ans = 0
for b in B:
    ans = max(ans, max(b))
print(ans)

# 나의 풀이
# N = int(input()) #도화지 크기
# # A = [ input() for _ in range(N) ] #도화지 색정보

# graph = [[] * N for _ in range(N)]
# result = [[0] * N for _ in range(N)]

# for i in range(N):
# 	temp = input()
# 	for j in range(len(temp)):
# 		graph[i].append(int(temp[j]))

# # print(graph)

# for color in range(1, 10):
# 	minI = minJ = 10
# 	maxI = maxJ = 0

# 	for i in range(N):
# 		for j in range(N):
# 			if graph[i][j] == color:
# 				# print(i, j)
# 				if minI > i: minI = i
# 				if minJ > j: minJ = j
# 				if maxI < i: maxI = i
# 				if maxJ < j: maxJ = j
# 	if minI == 10: continue
		
# 	# print(minI, minJ, maxI, maxJ)
		
# 	for i in range(minI, maxI+1):
# 		for j in range(minJ, maxJ+1):
# 			result[i][j] += 1

# m = 0
# for i in range(N):
# 	m = max(m, max(result[i]))

# print(m)