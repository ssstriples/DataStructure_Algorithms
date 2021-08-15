# # - 정수 n에 대해
# # - n이 홀수이면 3 X n + 1을 하고(2)
# # - n이 짝수이면 n을 2로 나눕니다(3)
# # - 이렇게 계속 진행해서 n이 결국 1이 될 때까지 (2)와 (3)의 과정을 반복합니다.
# # - 정수 n을 입력받아, 위 알고리즘에 의해 1이 되는 과정을 모두 출력하는 함수를 작성하세요.

# def func(n):
#     print(n)
#     if n == 1:
#         return n
    
#     if n % 2 == 1:
#         return (func(3 * n + 1))
#     else:
#         return (func(n // 2))

# func(3)

# - 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있음
#     - 1 + 1 + 1 + 1
#     - 1 + 1 + 2
#     - 1 + 2 + 1
#     - 2 + 1 + 1
#     - 2 + 2
#     - 1 + 3
#     - 3 + 1
# - 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오
# - Hint : f(n)은 f(n-1) + f(n-2) + f(n-3)과 동일하다는 패턴 찾기

def func(data):
    if data == 1:
        return 1
    elif data == 2:
        return 2
    elif data == 3:
        return 4
    else:
        return func(data - 1) + func(data - 2) + func(data - 3)

print(func(4))