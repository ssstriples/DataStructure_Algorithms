# 6. 디스플레이 필터
## 6.1. 문제 설명
- 디스플레이의 가시성을 높이기 위해서 얇은 필름형태의 필터를 개발 중이다.
- 최적의 성능을 낼 수 있도록 기본적으로 장착되어 나오는 필터 중 일부를 제거하여 성능을 향상시키려고 한다.

## 6.2. 요구 사항
- 디스플레이 개발팀에서는 디스플레이의 가시성 향상을 위해 얇은 필름 형태의 필터를 장착하기로 하였다.
- 필름은 외부 빛에 대해 반사 정도 R과 투과 정도 P의 특성을 가지며, 반사 정도는 **필터 각각의 반사 정도의 곱**이고 투과 정도는 **필터 각각의 투과 정도의 합**으로 나타낼 수 있다.
- 디스플레이에서 최적의 가시성을 확보하려면 반사 정도와 투과 정도가 조화를 이루어야 하며, **둘간의 차이가 최소**가 될수록 가시성이 높아진다.
- 그러나 디스플레이가 생산 될 때 N개의 필터가 장착되어 생산되므로 최적의 가시성을 확보하고 두께를 줄이기 위해서는 **불필요한 필터를 최대한 제거**할 필요가 있다.
- 최적의 가시성과 두께를 위해서 **제거해야 할 필터의 최대 개수**를 구하시오.
- 단, 디스플레이에는 **반드시 하나 이상의 필터**는 장착 되어야 한다.

## 6.3. 문제
### 6.3.1 입력 예시
- 다음과 같이 4개의 필터가 장착된 경우

  |필터|반사 정도|투과 정도|
  |:---:|:---:|:---:|
  |1|2|10|
  |2|2|8|
  |3|3|4|
  |4|4|12|
- 1번을 제거하면 반사 정도 2 * 3 * 4 = 24, 투과 정도는 8 + 4 + 12 = 24로 반사 정도와 투과 정도의 차가 0으로 가장 작아 진다.

- 최고의 성능을 내기 위해 제거해야 하는 필터의 개수를 구하시오.

### <입력 형식>
- 첫 번째 줄에는 장착된 필터의 수 N (N은 정수, 2 <= N <= 10)이 입력
- 두 번째 줄부터 N줄에 걸쳐 필터의 정보인 반사 정도 R (R은 정수, 1 <= N <= 20)과 투과 정도 P (P는 정수, 1 <= N <= 1,000,000)가 공백으로 구분되어 입력

### <출력 형식>
- 최고의 가시성과 두께를 위해 제거 해야 할 필터의 최대 개수를 출력

입력
<pre>
<code>
4
2 10
2 8
3 4
4 12
</code>
</pre>

출력
<pre>
<code>
1
</code>
</pre>

## 6.4 Code
<pre>
<code>
# 이진 Tree방식 : 조합
INF = int(1e9)
N = int(input())
R = list()
P = list()
for _ in range(N):
    temp = list(map(int, input().split()))
    R.append(temp[0])
    P.append(temp[1])
mindiff = INF
mincnt = N

def dfs(n, cnt, mul, sum):
    global mindiff, mincnt

    if cnt != 0 :
        diff = abs(mul - sum)
        if mindiff > diff or ((mindiff == diff) and (mincnt > cnt)):
            mindiff = diff
            mincnt = cnt
    
    if n >= N: return
    
    dfs(n+1, cnt+1, mul*R[n], sum+P[n]) # 선택O
    dfs(n+1, cnt, mul, sum) # 선택X
   
    for i in range(s, N):
        dfs(i+1, cnt+1, mul*R[i], sum+P[i])

dfs(0, 0, 1, 0)
print(N-mincnt)

# 다중 Tree방식 : 조합
INF = int(1e9)
N = int(input())
R = list()
P = list()
for _ in range(N):
    temp = list(map(int, input().split()))
    R.append(temp[0])
    P.append(temp[1])
mindiff = INF
mincnt = N

def dfs(s, cnt, mul, sum):
    global mindiff, mincnt
    if cnt != 0:
        diff = abs(mul - sum)
        if mindiff > diff or ((mindiff == diff) and (mincnt > cnt)):
            mindiff = diff
            mincnt = cnt
    
    for i in range(s, N):
        dfs(i+1, cnt+1, mul*R[i], sum+P[i])

dfs(0, 0, 1, 0)
print(N-mincnt)
</code>
</pre>
