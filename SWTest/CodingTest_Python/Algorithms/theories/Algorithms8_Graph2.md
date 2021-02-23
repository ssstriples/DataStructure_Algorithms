# 코딩 테스트 노트 with Python

## 10. 기타 그래프 이론

### 10.3 신장 트리
- *그래프에서 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프*를 의미합니다.
  - 모든 노드가 포함되어 서로 연결되면서 사이클이 존재하지 않는다는 조건은 **트리**의 조건이기도 합니다.

  <img src="../images/ST1.PNG" width="100%" height="100%" title="ST1" alt="ST1"></img><br/>

#### [최소 신장 트리]
- *최소한의 비용으로 구성되는 신장 트리를 찾아야 할 때* 어떻게 해야 할까요?
- 예를 들어 N개의 도시가 존재하는 상황에서 두 도시 사이에 도로를 놓아 **전체 도시가 서로 연결**될 수 있게 도로를 설치하는 경우를 생각해 봅시다.
  - 두 도시 A, B를 선택했을 때 A에서 B로 이동하는 경로가 반드시 존재하도록 도로를 설치합니다.

  <img src="../images/MST1.PNG" width="100%" height="100%" title="MST1" alt="MST1"></img><br/>

#### [크루스칼 알고리즘]
- 대표적인 **최소 신장 트리 알고리즘**입니다.
- 그리디 알고리즘으로 분류됩니다.
- 구체적인 동작 과정은 다음과 같습니다.
  1. 간선 데이터 비용에 따라 **오름차순으로 정렬**합니다.
  2. 간선을 하나씩 확인하며 *현재의 간선이 사이클을 발생시키는지 확인*합니다.
      - 1) 사이클이 발생하지 않는 경우, 최소 신장 트리에 포함시킵니다.
      - 2) 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않습니다.
  3. 모든 간선에 대하여 2번의 과정을 반복합니다.

#### [크루스칼 : 동작 과정]
- [초기 단계] 그래프의 모든 간선 정보에 대하여 **오름차순 정렬을 수행**합니다.

  <img src="../images/Kruskal1.PNG" width="100%" height="100%" title="Kruskal1" alt="Kruskal1"></img>

- [Step 1] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (3, 4)를 선택하여 처리합니다.

  <img src="../images/Kruskal2.PNG" width="100%" height="100%" title="Kruskal2" alt="Kruskal2"></img>

- [Step 2] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (4, 7)를 선택하여 처리합니다.

  <img src="../images/Kruskal3.PNG" width="100%" height="100%" title="Kruskal3" alt="Kruskal3"></img>

- [Step 3] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (4, 6)를 선택하여 처리합니다.

  <img src="../images/Kruskal4.PNG" width="100%" height="100%" title="Kruskal4" alt="Kruskal4"></img>

- [Step 4] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (6, 7)를 선택하여 처리합니다. 사이클이 발생하므로 무시합니다.

  <img src="../images/Kruskal5.PNG" width="100%" height="100%" title="Kruskal5" alt="Kruskal5"></img>

- [Step 5] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (1, 2)를 선택하여 처리합니다.

  <img src="../images/Kruskal6.PNG" width="100%" height="100%" title="Kruskal6" alt="Kruskal6"></img>

- [Step 6] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (2, 6)를 선택하여 처리합니다.

  <img src="../images/Kruskal7.PNG" width="100%" height="100%" title="Kruskal7" alt="Kruskal7"></img>

- [Step 7] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (2, 3)를 선택하여 처리합니다. 사이클이 발생하므로 무시합니다.

  <img src="../images/Kruskal8.PNG" width="100%" height="100%" title="Kruskal8" alt="Kruskal8"></img>

- [Step 8] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (5, 6)를 선택하여 처리합니다.

  <img src="../images/Kruskal9.PNG" width="100%" height="100%" title="Kruskal9" alt="Kruskal9"></img>

- [Step 9] 아직 처리하지 않은 간선 중에서 가장 짧은 간선인 (1, 5)를 선택하여 처리합니다. 사이클이 발생하므로 무시합니다.

  <img src="../images/Kruskal10.PNG" width="100%" height="100%" title="Kruskal10" alt="Kruskal10"></img>

#### [알고리즘 수행 결과]
- 최소 신장 트리에 포함되어 있는 간선의 비용만 모두 더하면, 그 값이 최종 비용에 해당합니다.

  <img src="../images/Kruskal11.PNG" width="100%" height="100%" title="Kruskal11" alt="Kruskal11"></img>

#### [Code]
<pre>
<code>
# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    # 루트 노드를 찾을 때까지 재귀 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간선(Union 연산)의 개수 입력 받기
v, e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화하기

# 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
edges = []
result = 0

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i

# 모든 간선에 대한 정보를 입력 받기
for _ in range(e):
    a, b, cost = map(int, input().split())
    # 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
    edges.append((cost, a, b))

# 간선을 비용순으로 정렬
edges.sort()

# 간선을 하나씩 확인하며
for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)
</code>
</pre>
입력
<pre>
<code>
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7 
4 6 23
4 7 13
5 6 53
6 7 25
</code>
</pre>
출력
<pre>
<code>
159
</code>
</pre>

#### [알고리즘 성능 분석]
- 크루스칼 알고리즘은 간선의 개수가 E개일 때, **O(ElogE)**의 시간 복잡도를 가집니다.
- 크루스칼 알고리즘에서 가장 많은 시간을 요구하는 곳은 간선의 정렬을 수행하는 부분입니다.
  - 표준 라이브러리를 이용해 E개의 데이터를 정렬하기 위한 시간 복잡도는 O(ElogE)입니다.