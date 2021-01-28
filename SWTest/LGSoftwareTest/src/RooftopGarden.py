n = int(input())
array = []

for _ in range(n):
    array.append(int(input()))

# i번째 건물을 볼 수 있는 건물들만 남겨서
# 마지막에 저장된 요소부터 차례로 비교해서 볼 수 있는 건물들만 남김
# LIFO 자료구조 스택을 이용

stack = []
sum = 0
for i in range(n):
    while len(stack) !=0 and stack[-1] <= array[i]:
        stack.pop()
    sum += len(stack)
    stack.append(array[i])
print(sum)


# Timeout 시간 복잡도 O(N^2) -> N이 80,000 이하이므로 시간 초과 발생!!
# tb = [0] * n
# for i in range(n):
#     for j in range(i + 1, n):
#         if array[i] > array[j]:
#             tb[i] += 1
#         else:
#             break
# print(sum(tb))