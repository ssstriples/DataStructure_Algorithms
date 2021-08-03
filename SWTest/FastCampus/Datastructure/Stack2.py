stack_list = list()

def push(data):
    stack_list.append(data)

def pop():
    data = stack_list[-1]
    del stack_list[-1]
    return data

for index in range(10):
    push(index)

print(stack_list)   # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print(pop())        # 9
print(stack_list)   # [0, 1, 2, 3, 4, 5, 6, 7, 8]