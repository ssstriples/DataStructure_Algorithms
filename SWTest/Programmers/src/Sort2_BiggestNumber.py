# 정렬2 : 가장큰수

# 시간 초과 O(len(numbers)!)이므로 완탐으로 할 수 없음
# from itertools import permutations

# def solution(numbers):
#     numbers = [str(i) for i in numbers]
#     # print(numbers)
    
#     perlist = list(map(''.join, permutations(numbers, len(numbers))))
#     print(perlist)
#     perlist.sort(reverse = True)
#     return str(perlist[0])

# print(solution([6, 10, 2]))

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key = lambda x : x*3, reverse=True)
    return str(int(''.join(numbers)))

print(solution([6, 10, 2]))