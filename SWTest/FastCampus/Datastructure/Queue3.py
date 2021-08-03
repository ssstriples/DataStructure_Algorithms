import queue

data_queue = queue.PriorityQueue()
data_queue.put((10, "korea"))
data_queue.put((5, 1))
data_queue.put((15, "japan"))

print(data_queue.qsize())   # 3
print(data_queue.get())     # (5, 1) 
print(data_queue.qsize())   # 2
print(data_queue.get())     # (10, 'korea')
print(data_queue.qsize())   # 1
print(data_queue.get())     # (15, 'japan')