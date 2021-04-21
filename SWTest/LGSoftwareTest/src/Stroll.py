# 산책

# 정방향 탐색 + 그룹의 선두를 Stack을 통해서 관리
import sys
read = sys.stdin.readline

N, T = map(int, read().split())
PS = []
for _ in range(N):
	temp = tuple(map(int, read().split()))
	PS.append(temp)

stack = []
for i in range(N):
    pos = PS[i][0] + T * PS[i][1]
    while stack and stack[-1] >= pos:	# stack - top : stack[-1]
        stack.pop()
    stack.append(pos)
print(stack)
print(len(stack))

# 역방향 탐색을 이용한 Python문제 풀이
# import sys
# read = sys.stdin.readline

# N, T = map(int, read().split())
# A = []
# for _ in range(N):
# 	A.append(list(map(int, read().split())))

# B = []
# for p, s in A:
#     B.append(p+T*s)

# B.reverse()
# pre = B[0]
# C = {pre}

# for b in B:
#     if pre > b:
# 	    C.add(b)
# 	    pre = b
# print(len(C))

# 나의 풀이
# N, T = map(int, input().split())
# PS= []

# for _ in range(N):
# 	temp = tuple(map(int, input().split()))
# 	PS.append(temp)

# # print(N, T)
# # print(PS)
# PS.sort(reverse = True)
# # print(PS)

# result = []

# for p, s in PS:
# 	result.append(p + (s * T))
	
# # print(result)	
	
# for i in range(len(result)):
# 	if i != 0 and result[i-1] < result[i]:
# 		result[i] = result[i-1]

# # print(result)
# result = set(result)
# # print(result)
# print(len(result))