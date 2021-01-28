# 코딩 테스트 노트 with Python

## 9. 최단 경로 프로그래밍

### 9.1 최단 경로(Shortest Path)
- 최단 경로 알고리즘은 **가장 짧은 경로를 찾는 알고리즘**을 의미합니다.
- 다양한 문제 상황
  - 한 지점에서 다른 한 지점까지의 최단 경로
  - 한 지점에서 다른 모든 지점까지의 최단 경로
  - 모든 지점에서 다른 모든 지점까지의 최단 경로
- 각 지점은 그래프에서 노드로 표현
- 지점 간 연결된 도로는 그래프에서 간선으로 표현
  
  <img src="../images/SP1.PNG" width="70%" height="100%" title="SP1" alt="SP1"></img><br/>

### 9.2 다익스트라 최단 경로 알고리즘
#### [개요]
- **특정한 노드**에서 출발하여 **다른 모든 노드**로 가는 최단 경로를 계산합니다.
- 다익스트라 최단 경로 알고리즘은 음의 간선이 없을 때 정상적으로 동작합니다.
  - 현실 세계의 도로(간선)은 음의 간선으로 표현되지 않습니다.
- 다익스트라 최단 경로 알고리즘은 *그리디 알고리즘*으로 분류됩니다.
  - **매 상황에서 가장 비용이 적은 노드를 선택**해 임의의 과정을 반복합니다.

#### [동작 과정]
- 알고리즘의 **동작 과정**은 다음과 같습니다.
  1. 출발 노드를 설정합니다.
  2. 최단 거리 테이블을 초기화합니다.
  3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택합니다.
  4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신합니다.
  5. 위 과정에서 3번과 4번을 반복합니다.

- 알고리즘 동작 과정에서 최단 거리 테이블은 각 노드에 대한 현재까지의 최단 거리 정보를 가지고 있습니다.
- 처리 과정에서 더 짧은 경로를 찾으면 '이제부터는 이 경로가 제일 짧은 경로야'라고 갱신합니다.

   <img src="../images/SP2.PNG" width="40%" height="100%" title="SP2" alt="SP2"></img> 
   <img src="../images/SP3.PNG" width="40%" height="100%" title="SP3" alt="SP3"></img><br/>

- [초기 상태] 그래프를 준비하고 출발 노드를 설정합니다.

  <img src="../images/SP4.PNG" width="100%" height="100%" title="SP4" alt="SP4"></img><br/>

- [Step 1] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 1번 노드를 처리합니다.

  <img src="../images/SP5.PNG" width="100%" height="100%" title="SP5" alt="SP5"></img><br/>

- [Step 2] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 4번 노드를 처리합니다.

  <img src="../images/SP6.PNG" width="100%" height="100%" title="SP6" alt="SP6"></img><br/>

- [Step 3] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 2번 노드를 처리합니다.

  <img src="../images/SP7.PNG" width="100%" height="100%" title="SP7" alt="SP7"></img><br/>

- [Step 4] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 5번 노드를 처리합니다.

  <img src="../images/SP8.PNG" width="100%" height="100%" title="SP8" alt="SP8"></img><br/>

- [Step 5] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 3번 노드를 처리합니다.

  <img src="../images/SP9.PNG" width="100%" height="100%" title="SP9" alt="SP9"></img><br/>

- [Step 6] 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드인 6번 노드를 처리합니다.

  <img src="../images/SP10.PNG" width="100%" height="100%" title="SP10" alt="SP10"></img><br/>

#### [특징]
- 그리디 알고리즘 : **매 상황에서 방문하지 않은 가장 비용이 적은 노드를 선택**해 임의의 과정을 반복합니다.
- 단계를 거치며 *한 번 처리된 노드의 최단 거리는 고정*되어 더 이상 바뀌지 않습니다.
  - **한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는 것으로 이해**할 수 있습니다.
- 다익스트라 알고리즘을 수행한 뒤에 *테이블에 각 노드까지의 최단 거리 정보가 저장*됩니다.
  - 완벽한 형태의 최단 경로를 구하려면 소스코드에 추가적인 기능을 더 넣어야 합니다.

#### [간단한 구현 방법]
- 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하기 위해 **매 단계마다 1차원 테이블의 모든 원소를 확인(순차 탐색)** 합니다.

#### [간단한 구현 방법 : Code]
<pre>
<code>
import sys
input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n + 1)]
# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False] * (n + 1)
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b, c))     # tuple (b, c) : detination _ b , weight _ c

# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
def get_smallest_node():
    min_value = INF
    index = 0 # 가장 최단 거리가 짧은 노드(인덱스)
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index

def dijkstra(start):
    # 시작 노드에 대해서 초기화
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]   # 목적지 j[0]의 거리 j[1]로 초기화
    # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
    for i in range(n - 1):
        # 현재 치단 거리가 가장 짧은 노드를 꺼내서, 방문처리
        now = get_smallest_node()
        visited[now] = True
        # 현재 노드와 연결된 다른 노드를 확인
        for j in graph[now]:
            cost = distance[now] + j[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 distance 테이블 갱신
            if cost < distance[j[0]]:
                distance[j[0]] = cost

# 다익스트라 알고리즘을 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    # 도달할 수 없는 경우, 무한(INFINITY) 출력
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])
</code>
</pre>
입력
<pre>
<code>
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
</code>
</pre>
출력
<pre>
<code>
0
2
3
1
2
4
</code>
</pre>
#### [간단한 구현 방법 : 성능 분석]
- 총 O(V)번에 걸쳐서 최단 거리가 가장 짧은 노드를 매번 선형 탐색해야 합니다.
- 따라서 전체 시간 복잡도는 O(V^2)입니다.
- 일반적으로 코딩 테스트의 최단 경로 문제에서 전체 노드의 개수가 5,000개 이하라면 이 코드로 문제를 해결할 수 있습니다.
  - 하지만 노드의 개수가 10,000개를 넘어가는 문제라면 어떻게 해야할까요?

---

### 9.3 우선순위 큐(Priority Queue)
- **우선순위가 가장 높은 데이터를 가장 먼저 삭헤**하는 자료구조입니다.
- 예를 들어 여러 개의 물건 데이터를 자료구조에 넣었다가 가치가 가장 높은 물건 데이터부터 꺼내서 확인해야하는 경우에 우선순위 큐를 이용할 수 있습니다.
- Python, C++, Java를 포함한 대부분의 프로그래밍 언어에서 표준 라이브러리 형태로 지원합니다.

  |자료구조|추출되는 데이터|
  |:---:|:---:|
  |스택(Stack)|가장 나중에 삽입된 데이터|
  |큐(Queue)|가장 먼저 삽입된 데이터|
  |우선순위 큐(Priority Queue)|가장 우선순위가 높은 데이터|

---

### 9.4 힙(Heap)
- 우선순위 큐(Priority Queue)를 구현하기 위해 사용하는 자료구조 중 하나입니다.
- **최소 힙(Min Heap)** 과 **최대 힙(Max Heap)** 이 있습니다.
- 다익스트라 최단 경로 알고리즘을 포함해 다양한 알고리즘에서 사용됩니다.

  |우선순위 큐 구현 방식|삽입 시간|삭제 시간|
  |:---:|:---:|:---:|
  |리스트|O(1)|O(N)|
  |힙(Heap)|O(logn)|O(logn)|

#### [힙 라이브러리 사용 예제 : 최소 힙]
<pre>
<code>
import heapq

# 오름차순 힙 정렬(Heap Sort)
def heapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, value)
    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(heapq.heappop(h))
    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result)
</code>
</pre>
실행 결과
<pre>
<code>
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
</code>
</pre>

#### [힙 라이브러리 사용 예제 : 최소 힙]
<pre>
<code>
import heapq

# 내림차순 힙 정렬(Heap Sort) : Min Heap에 value 부호 바꾸어 작게 만든다음 꺼낼때 다시 바꾸어 응용
def heapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, -value)
    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(-heapq.heappop(h))
    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result)
</code>
</pre>
실행 결과
<pre>
<code>
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
</code>
</pre>

### 9.5 다익스트라 최단 경로 알고리즘
#### [개선된 구현 방법]
- 단계마다 *방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택*하기 위해 **힙(Heap)** 자료구조를 이용합니다.
- 다익스트라 알고리즘이 동작하는 기본 원리는 동일합니다.
  - 현재 가장 가까운 노드를 저장해 놓기 위해서 힙 자료구조를 추가적으로 이용한다는 점이 다릅니다.
  - 현재의 **최단 거리가 가장 짧은 노드를 선택해야 하므로 최소 힙을 사용**합니다.

#### [동작 과정]
- [초기 상태] 그래프를 준비하고 출발 노드를 설정하여 우선순위 큐에 삽입합니다.

  <img src="../images/DIJK1.PNG" width="100%" height="100%" title="DIJK1" alt="DIJK1"></img><br/>

- [Step 1] 우선순위 큐에서 원소를 꺼냅니다. 1번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK2.PNG" width="100%" height="100%" title="DIJK2" alt="DIJK2"></img><br/>
 
- [Step 2] 우선순위 큐에서 원소를 꺼냅니다. 4번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK3.PNG" width="100%" height="100%" title="DIJK3" alt="DIJK3"></img><br/>

- [Step 3] 우선순위 큐에서 원소를 꺼냅니다. 2번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK4.PNG" width="100%" height="100%" title="DIJK4" alt="DIJK4"></img><br/>

- [Step 4] 우선순위 큐에서 원소를 꺼냅니다. 5번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK5.PNG" width="100%" height="100%" title="DIJK5" alt="DIJK5"></img><br/>

- [Step 5] 우선순위 큐에서 원소를 꺼냅니다. 3번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK6.PNG" width="100%" height="100%" title="DIJK6" alt="DIJK6"></img><br/>

- [Step 6] 우선순위 큐에서 원소를 꺼냅니다. 3번 노드는 이미 방문했으므로 무시합니다.

  <img src="../images/DIJK7.PNG" width="100%" height="100%" title="DIJK7" alt="DIJK7"></img><br/>

- [Step 7] 우선순위 큐에서 원소를 꺼냅니다. 6번 노드는 아직 방문하지 않았으므로 이를 처리합니다.

  <img src="../images/DIJK8.PNG" width="100%" height="100%" title="DIJK8" alt="DIJK8"></img><br/>

- [Step 8] 우선순위 큐에서 원소를 꺼냅니다. 3번 노드는 이미 방문했으므로 무시합니다.

  <img src="../images/DIJK9.PNG" width="100%" height="100%" title="DIJK9" alt="DIJK9"></img><br/>

#### [개선된 구현 방법 : Code]
<pre>
<code>
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n + 1)]
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b, c))     # tuple (b, c) : detination _ b , weight _ c

def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
# 다익스트라 알고리즘을 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    # 도달할 수 없는 경우, 무한(INFINITY) 출력
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])
</code>
</pre>
입력
<pre>
<code>
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
</code>
</pre>
출력
<pre>
<code>
0
2
3
1
2
4
</code>
</pre>

#### [개선된 구현 방법 : 성능 분석]
- 힙 자료구조를 이용하는 다익스트라 알고리즘의 시간 복잡도는 **O(ElogV)** 입니다.
- 노드를 하나씩 꺼내 검사하는 반복문(while문)은 노드의 개수 V이상의 횟수로는 처리되지 않습니다.
  - 결과적으로 현재 우선순위 큐에서 꺼낸 노드와 연결된 다른 노드들을 확인하는 총횟수는 최대 간선의 개수(E)만큼 연산이 수행될 수 있습니다.
- 직관적으로 *전체 과정은 E개의 원소를 우선순위 큐에 넣었다가 모두 빼내는 연산과 매우 유사*합니다.
  - 시간 복잡도를 O(ElogE)로 판단할 수 있습니다.
  - 중복 간선을 포함하지 않는 경우에 이를 O(ElogV)로 정리할 수 있습니다.
    - O(ElogE) -> O(ElogV^2) -> O(2ElogV) -> O(ElogV)
  