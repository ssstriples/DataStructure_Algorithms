# 코딩 테스트 노트 with Python

## 5. 그래프 탐색 알고리즘: DFS / BFS

### 5.10 DFS/BFS 문제 : 음료수 얼려 먹기
#### [문제 설명]
- N X M 크기의 얼음 틀이 있습니다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시됩니다. 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주합니다.
이때, **얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성**하세요. 다음의 4 X 5 얼음 틀 예시에서는 아이스크림이 총 3개가 생성됩니다.
<img src="../images/DFS_BFS_Problem1.PNG" width="100%" height="100%"></img><br/>

#### [문제 조건]
<img src="../images/DFS_BFS_Problem1_2.PNG" width="100%" height="100%"></img><br/>

#### [아이디어]
- 이 문제는 DFS 혹은 BFS로 해결할 수 있습니다. 일단 앞에서 배운대로 얼음을 얼릴 수 있는 공간이 상, 하, 좌, 우로 연결되어 있다고 표현할 수 있으므로 **그래프 형태로 모델링**할 수 있습니다. 다음과 같이 3 X 3 크기의 얼음 틀이 있다고 가정하고 생각해 봅시다.
<img src="../images/DFS_BFS_Problem1_3.PNG" width="50%" height="50%"></img><br/>

- DFS를 활용하는 알고리즘은 다음과 같습니다.
    1. 특정한 지점의 주변 상, 하, 좌, 우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문합니다.
    2. 방문한 지점에서 다시 상, 하, 좌, 우를 살펴보면서 방문을 진행하는 과정을 반복하면, **연결된 모든 지점을 방문**할 수 있습니다.
    3. 모든 노드에 대하여 1 ~ 2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트합니다.

#### [Code]
<pre>
<code>
# N, M을 공백을 기준으로 구분하여 입력 받기
n, m = map(int, input().split())

# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x, y):
    # 주어진 범위를 벗어나는 경우 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False

    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        # 해당 노드 방문 처리
        graph[x][y] = 1
        # 상, 하, 좌, 우 위치들도 모두 재귀적으로 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    else:
        return False

# 모든 노드(위치)에 대하여 음료수 채우기
count = 0
for x in range(n):
    for y in range(m):
        # 현재 위치에서 DFS 수행
        if dfs(x, y) == True:
            count+=1

print(count)
</code>
</pre>

---
### 5.11 DFS/BFS 문제 : -
#### [문제 설명]
- 

#### [문제 조건]
<img src="../images/DFS_BFS_Problem.PNG" width="100%" height="100%"></img><br/>
