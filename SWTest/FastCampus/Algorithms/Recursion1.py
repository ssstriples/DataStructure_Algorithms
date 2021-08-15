# # 1부터 num까지의 곱 출력
# def multiple(data):
#     if data <= 1:
#         return data
#     return data * multiple(data - 1)

# print(multiple(10))


# # 리스트의 합을 리턴하는 함수
# import random
# data = random.sample(range(100), 10)
# # print(data)

# def sum_list(data):
#     # print(data)
#     if len(data) <= 1:
#         return data[0]

#     return data[0] + sum_list(data[1:])

# print(sum_list(data))
# # print(data)



# 회문 판별
# string = 'Dave'
# print(string[-1])   # e
# print(string[0])    # D
# print(string[1:-1]) # av
# print(string[:-1])  # Dav

def palindrome(string):
    if len(string) <= 1:
        return True
    
    if string[0] == string[-1]:
        return palindrome(string[1:-1])
    else:
        return False

print(palindrome('level'))