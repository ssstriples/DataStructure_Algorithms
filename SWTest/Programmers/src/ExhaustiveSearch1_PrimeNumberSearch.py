# 완전탐색1 : 소수찾기
from itertools import permutations
import math

def isPrime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    result = []
    
    for i in range(1, len(numbers) + 1):
        perlist = list(map(''.join, permutations(numbers, i)))
        # print(perlist)
        for j in list(set(perlist)):
            result.append(int(j))
        print(result)

    for num in list(set(result)):
        if num == 0 or num == 1:
            continue
        if isPrime(num):
            answer +=1
    return answer

print(solution(input()))