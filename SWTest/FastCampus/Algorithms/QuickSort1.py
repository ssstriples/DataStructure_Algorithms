import random
data_list = random.sample(range(100), 10)

def qsort(data):
    if len(data) <= 1:
        return data
    
    left, right = list(), list()
    pivot = data[0]

    for index in range(1, len(data)):
        if pivot > data[index]:
            left.append(data[index])
        else:
            right.append(data[index])
    
    return qsort(left) + [pivot] + qsort(right)

print("정렬 전 : ", data_list)
print("정렬 후 : ", qsort(data_list))