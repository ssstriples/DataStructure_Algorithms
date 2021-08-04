class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next

class NodeMgmt:
    def __init__(self, data):
        self.head = Node(data)

    def add(self, data):
        if self.head == None:
            self.head = Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = Node(data)

    def desc(self):
        node = self.head
        while node:
            print(node.data, end=" ")
            node = node.next
        print()
    
    def delete(self, data):
        if self.head == None:
            print("해당 값을 가진 노드가 없습니다.")
            return
        
        if self.head.data == data:
            temp = self.head
            self.head = self.head.next
            del temp    # 객체 삭제
        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next
                    node.next = node.next.next
                    del temp
                else:
                    node = node.next
    
    def search_node(self, data):
        node = self.head
        while node:
            if node.data == data:
                return node
            else:
                node = node.next

linkedlist1 = NodeMgmt(0)
# 1. HEAD 삭제
linkedlist1.delete(0)

for data in range(1, 10):
    linkedlist1.add(data)
linkedlist1.desc()

# 2. 마지막 노드 삭제
linkedlist1.delete(9)
linkedlist1.desc()

# 3. 중간 노드 삭제
linkedlist1.delete(4)
linkedlist1.desc()