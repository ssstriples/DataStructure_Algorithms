queue_list = list()

def enqueue(data):
    queue_list.append(data)

def dequeue():
    data = queue_list[0]
    del queue_list[0]   # 삭제 후 재정렬
    return data

for index in range(10):
    enqueue(index)

print(len(queue_list))  # 10
print(dequeue())    # 0
print(dequeue())    # 1
print(dequeue())    # 2
print(len(queue_list))  # 7