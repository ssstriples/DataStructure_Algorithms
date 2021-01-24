# DP Practice #1 : 개미 전사

# 정수 N을 입력 받기
n = int(input())
# 모든 식량 정보 입력 받기
array = list(map(int, input().split()))

# 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
d = [0] * 100

# 다이나믹 프로그래밍(Dynamic Programming) 진행(Bottom Up)

d[0] = array[0]
d[1] = max(array[0], array[1])
for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + array[i])

# 계산된 결과 출력 
print(d[n - 1])

# Top down
# def solution(arr, n):
#     if n == 0:
#         return arr[0]
#     if n == 1:
#         return max(arr[0], arr[1])

#     if (solution(arr, n-1) < (solution(arr, n-2) + arr[n])):
#         return solution(arr, n-2) + arr[n]
#     else:
#         return solution(arr, n-1)
    
# print(solution(arr, n-1))