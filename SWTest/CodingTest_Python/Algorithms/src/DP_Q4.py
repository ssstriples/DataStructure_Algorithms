# DP Practice #4 : 금광

# 테스트 케이스(Test Case)입력
for tc in range(int(input())):
    # 금광 정보 입력
    n, m = map(int, input().split())
    array = list(map(int, input().split()))
    
    # 다이나믹 프로그래밍을 위한 2차원 DP테이블 초기화
    dp = []
    index = 0
    for i in range(n):
        dp.append(array[index : index + m])
        index += m
    
    # 다이나믹 프로그래밍 진행
    for j in range(1, m):
        for i in range(n):
            # 왼쪽 위에서 오는 경우
            if i == 0: left_up = 0
            else: left_up = dp[i - 1][j - 1]
            # 왼쪽 아래에서 오는 경우
            if i == n - 1 : left_down = 0
            else: left_down = dp[i + 1][j - 1]
            # 왼쪽에서 오는 경우
            left = dp[i][j - 1]
            dp[i][j] = dp[i][j] + max(left_up, left_down, left)
    
    result = 0
    for i in range(n):
        result = max(result, dp[i][m - 1])
    print(result)




# def validBound(i, j):
#     if i < 0 or i >= n or j < 0 or j >= m:
#         return False
#     return True

# # 정수 N, M을 입력 받기
# n, m = map(int, input().split())

# array = [[0] * m for _ in range(n)]
# for i in range(n):
#     for j in range(m):
#         array[i][j] = int(input())

# # 한 번 계산된 결과를 저장하기 위한 DP 테이블 초기화
# d = [[0] * m for _ in range(n)]
# for i in range(n):
#     d[i][0] = array[i][0]
# print(d)

# # 다이나믹 프로그래밍(Dynamic Programming) 진행(Bottom Up)
# for i in range(1, n):
#     for j in range(m):
#         d[i][j] = max(d[i][j], d[i][j-1] + array[i][j])
#         if validBound(i - 1, j - 1):
#             d[i][j] = max(d[i][j], d[i-1][j-1] + array[i][j])
#         if validBound(i + 1, j - 1):
#             d[i][j] = max(d[i][j], d[i+1][j-1] + array[i][j])
    
# ans =  d[0][m - 1]
# for i in range(1, n):
#     ans = max(ans, d[i][m-1])

# print(ans)
# print(d)