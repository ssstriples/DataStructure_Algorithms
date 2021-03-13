
# 도화지 크기 N 입력 받기
N = int(input())

# 도화지 색 정보 입력 받기
A = [[0] * N for _ in range(N)]
for i in range(N):
    A[i] = list(input())

# print(N)
# print(A)

# 색 정보
check = [0] * 10

def solve():
    
    for i in range(1, 10):  # 1번 색부터 9번 색 까지 start,end (row,col) 찾는 로직
        minr = minc = 10
        maxr = maxc = 0        
        
        # row,column min/max 찾기
        for r in range(N):
            for c in range(N):
                curColor = int(A[r][c])
                if curColor != i: continue
                if minr > r: minr = r
                if maxr < r : maxr = r
                if minc > c : minc = c
                if maxc < c : maxc = c
        
        if minr == 10: continue # 해당 색 없음

        # 해당 색 방문
        check[i] += 1
        for r in range(minr, maxr + 1):
            for c in range(minc, maxc + 1):
                curColor = int(A[r][c])
                if curColor == i: continue  # 현재 색이랑 같으면 무시
                check[curColor] += 1    # 다르면 ++               

    # check list 1로 카운트 된 색이 다른 색을 덧칠하지 않은 색
    cnt = 0
    for i in range(1, 10):
        if check[i] == 1: cnt += 1
    
    return cnt

print(solve())