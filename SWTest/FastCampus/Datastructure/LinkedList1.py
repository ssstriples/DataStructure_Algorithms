class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next

# 링크드 리스트 데이터 추가하기
def add(data):
    node = head
    while node.next:
        node = node.next
    node.next = Node(data)

node1 = Node(1)
# node2 = Node(2)
# node1.next = node2
head = node1
for index in range(2, 10):
    add(index)

# 링크드 리스트 데이터 사이에 데이터를 추가
node3 = Node(1.5)
node = head
search = True
while search:
    if node.data == 1:
        search = False
    else:
        node = node.next
print(node.data)

node_next = node.next
node.next = node3
node3.next = node_next

# 링크드 리스트 데이터 순회
node = head
while node.next:
    print(node.data, end=" ")
    node = node.next
print(node.data)    # 마지막 데이터 출력
