import random
data_list = random.sample(range(100), 10)

def binary_search(data, search):
    if len(data) == 1 and search == data[0]:
        return True

    if len(data) == 1 and search != data[0]:
        return False

    if len(data) == 0:
        return False

    medium = len(data) // 2
    if search == data[medium]:
        return True
    elif search > data[medium]:
        return binary_search(data[medium + 1:], search)
    else:
        return binary_search(data[:medium], search)
    
data_list.sort()
print(data_list)
print(binary_search(data_list, 10))