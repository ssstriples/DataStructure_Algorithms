n = int(input())
array = []

for _ in range(n):
    array.append(int(input()))

#print(array)
tb = [0] * n

for i in range(n):
    for j in range(i + 1, n):
        if array[i] > array[j]:
            tb[i] += 1
        else:
            break
print(sum(tb))


# Timeout
# for i in range(n):
#     for j in range(i + 1, n):
#         if array[i] > array[j]:
#             tb[i] += 1
#         else:
#             break