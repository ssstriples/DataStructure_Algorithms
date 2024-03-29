# 코딩 테스트 노트 with Python

## 2. 파이썬 문법

### 1.1 자료형
- 모든 프로그래밍은 결국 데이터를 다루는 행위입니다.
  - 자료형에 대한 이해는 프로그래밍의 길에 있어서 첫걸음이라고 할 수 있습니다.
- 파이썬의 자료형으로는 **정수형, 실수형, 복소수형, 문자열, 리스트, 튜플, 사전** 등이 있습니다.
  - 파이썬의 자료형은 필수적을 알아두어야 합니다.


### 1.2. 정수형
- 정수형(Integer)은 정수를 다루는 자료형입니다.
  - 양의 정수, 음의 정수, 0이 포함됩니다.
- 코딩 테스트에서 출제되는 많은 문제들은 정수형을 주로 다루게 됩니다.
<pre>
<code>
# 양의 정수
a = 1000
print(a)

# 음의 정수
a = -7
print(a)

# 0
a = 0
print(a)
</code>
</pre>

실행 결과
<pre>
<code>
1000
-7
0
</code>
</pre>

### 1.3. 실수형
- 실수형(Real Number)은 소수점 아래의 데이터를 포함하는 수 자료형입니다.
  - 파이썬에서는 변수에 소수점을 붙인 수를 대입하면 실수형 변수로 처리됩니다.
  - 소수부가 0이거나, 정수부가 0인 소수는 0을 생략하고 작성할 수 있습니다.
<pre>
<code>
# 양의 실수
a = 157.93
print(a)

# 음의 실수
a = -1837.2
print(a)

# 소수부가 0일 때 0을 생략
a = 5.
print(a)

# 정수부가 0일 때 0을 생략
a = -.7
print(a)
</code>
</pre>

실행 결과
<pre>
<code>
157.93
-1837.2
5.0
-0.7
</code>
</pre>

### 1.4. 지수 표현 방식
- 파이썬에서는 e나 E를 이용한 **지수 표현 방식**을 이용할 수 있습니다.
  - e나 E 다음에 오는 수는 10의 지수부를 의미합니다.
  - 예를들어 1e9라고 입력하게 되면, 10의 9제곱(1,000,000,000)이 됩니다.
    -  유효숫자e^지수 = 유효숫자 * 10^지수
- 지수 표현 방식은 임의의 큰 수를 표현하기 위해 자주 사용됩니다.
- 최단 경로 알고리즘에서는 도달할 수 없는 노드에 대하여 최단 거리를 **무한(INF)**로 설정하곤 합니다.
- 이때 가능한 최댓값이 10억 미만이라면 무한(INF)의 값으로 1e9를 이용할 수 있습니다.
<pre>
<code>
# 1,000,000,000의 지수 표현 방식
a = int(1e9)
print(a)

# 752.5
a = 75.25e1
print(a)

# 3.954
a = 3954e-3
print(a)
</code>
</pre>

실행 결과
<pre>
<code>
1,000,000,000
752.5
3.954
</code>
</pre>

### 1.5. 실수형 더 알아보기
- 오늘날 가장 널리 쓰이는 IEEE754 표준에서는 실수형을 저장하기 위해 4바이트, 혹은 8바이트의 고정된 크기의 메모리를 할당하므로, 컴퓨터 시스템은 **실수 정보를 표현하는 정확도에 한계**를 가집니다.
- 예를 들어 10진수 체계에서는 0.3과 0.6을 더한 값이 0.9로 정확히 떨어집니다.
  - 하지만 2진수에서는 0.9를 정확히 표현할 수 있는 방법이 없습니다.
  - 컴퓨터는 최대한 0.9와 가깝게 표현하지만, 미세한 오차가 발생하게 됩니다.

<pre>
<code>
a = 0.3 + 0.6
print(a)

if a == 0.9:
  print(True)
else:
  print(False)
</code>
</pre>

실행 결과
<pre>
<code>
0.8999999999999999
False
</code>
</pre>

### 1.6. 실수형 더 알아보기2
- 개발 과정에서 실수 값을 제대로 비교하지 못해서 원하는 결과를 얻지 못할 수 있습니다.
- 이럴 때는 **round()함수**를 이용할 수 잇으며, 이러한 방법이 권장됩니다.
- 예를 들어 123.456을 소수 셋째 자리에서 반올림하려면 round(123.456, 2)라고 작성합니다.
  - 결과는 123.46이 됩니다.
<pre>
<code>
a = 0.3 + 0.6
print(round(a, 4))

if round(a, 4) == 0.9:
  print(True)
else:
  print(False)
</code>
</pre>

실행 결과
<pre>
<code>
0.9
True
</code>
</pre>


### 1.7. 수 자료형의 연산
- 수 자료형에 대하여 사직연산과 나머지 연산자가 많이 사용됩니다.
- 단 나누기 연산자(/)를 주의해서 사용해야 합니다.
  - 파이썬에서 나누기 연산자(/)는 **나눠진 결과를 실수형**으로 반환합니다.
- 다양한 로직을 설계할 때 나머지 연산자(%)를 이용해야 할 때가 많습니다.
  - 예시 : a가 홀수인지 체크해야 하는 경우
- 파이썬에서는 몫을 얻기 위해 몫 연산자(//)를 사용합니다.
- 이외에도 거듭 제곱 연산자(**)를 비롯해 다양한 연산자들이 존재합니다.

<pre>
<code>
a = 7
b = 3

# 나누기
print(a / b)

# 나머지
print(a % b)

# 몫
print(a // b)

a = 5
b = 3

# 거듭 제곱
print(a ** b)

# 제곱근
print(a ** 0.5)
</code>
</pre>

실행 결과
<pre>
<code>
2.3333333333333335
1
2
125
2.23606797749979
</code>
</pre>
---