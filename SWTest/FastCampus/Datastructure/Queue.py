import queue

data_queue = queue.Queue()
data_queue.put("funcoding")
data_queue.put(1)

print(data_queue.qsize())   // 2
print(data_queue.get())     // funcoding
print(data_queue.qsize())   // 1