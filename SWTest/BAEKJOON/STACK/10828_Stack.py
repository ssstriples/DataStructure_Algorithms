import sys
N = int(sys.stdin.readline())   # 백준에서 일반 input()으로 시간초과됨

stack = list()

def push(data):
    stack.append(data)

def pop():
    if empty():
        return -1
    return stack.pop()

def size():
    return len(stack)

def empty():
    return not bool(stack)

def top():
    if empty():
        return -1
    return stack[-1]

while N:
    C = sys.stdin.readline()
    if "pu" in C:
        C, V = C.split()
        push(V)
    elif "po" in C:
        print(pop())
    elif "s" in C:
        print(size())
    elif "e" in C:
        print(int(empty()))
    elif "t" in C:
        print(top())
    N -= 1