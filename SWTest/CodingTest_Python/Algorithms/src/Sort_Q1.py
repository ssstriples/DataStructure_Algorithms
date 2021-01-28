# 정렬 문제 1 : 두 배열의 원소 교체

# N과 K를 입력 받기
n, k = map(int, input().split())
# 배열 A의 모든 원소를 입력 받기
a = list(map(int, input().split()))
# 배열 B의 모든 원소를 입력 받기
b = list(map(int, input().split()))

# 배열 A는 오름차순 정렬 수행
a.sort()
# 배열 B는 내림차순 정렬 수행
b.sort(reverse = True)

# 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
for i in range(k):
    # A의 원소가 B의 원소보다 작은 경우
    if a[i] < b[i]:
        # 두 원소를 교체
        a[i], b[i] = b[i], a[i]
    # A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
    else:
        break
# 배열 A의 모든 원소의 합 출력
print(sum(a))