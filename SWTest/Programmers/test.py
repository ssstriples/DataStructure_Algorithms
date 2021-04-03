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
        
        for j in list(set(perlist)):
            result.append(int(j))

    for num in list(set(result)):
        if num == 0 or num == 1:
            continue

        if isPrime(num):
            answer+=1
    return answer

print(solution(input()))


# https://programmers.co.kr/learn/courses/30/lessons/42839/solution_groups?language=python3