# 큐1 : 기능 개발
from collections import deque

def solution(progresses, speeds):
    answer = []
    queue = deque(progresses)
    speeds = deque(speeds)

    while queue:
        for i in range(len(queue)):
            queue[i] += speeds[i]

        count = 0
        if queue[0] >= 100:
            for j in range(len(queue)):
                if queue[j] >= 100:
                    count += 1
                else:
                    break
            answer.append(count)
        for k in range(count):
            queue.popleft()
            speeds.popleft()

    return answer

progresses = list(map(int, input().split()))
speeds = list(map(int, input().split()))
print(solution(progresses, speeds))