# 코딩 테스트 노트 with Python

## 2. 파이썬 문법

### 7.1 반복문
- 특정한 소스코드를 반복적으로 실행하고자 할 때 사용하는 문법입니다.
- 파이썬에서는 while문과 for문이 있는데, 어떤 것을 사용해도 상관 없습니다.
  - 다만 코딩 테스트에서의 실제 사용 예시를 확인해 보면, for문이 더 간결한 경우가 많습니다.
  
반복문 예제 : 1부터 9까지 모든 정수의 합 구하기 예제(While문)
<pre>
<code>
i = 1
result = 0

# i가 9보다 작거나 같을 떄 아래 코드를 반복적으로 실행
while i <= 9:
    result += i
    i += 1

print(result)
</code>
</pre>
실행 결과
<pre>
<code>
45
</code>
</pre>

반복문 예제 : 1부터 9까지 홀수의 합 구하기 예제(While문)
<pre>
<code>
i = 1
result = 0

# i가 9보다 작거나 같을 떄 아래 코드를 반복적으로 실행
while i <= 9:
    if i % 2 == 1:
        result += i
    i += 1

print(result)
</code>
</pre>
실행 결과
<pre>
<code>
25
</code>
</pre>

### 7.2 반복문에서의 무한 루프
- 무한 루프(Infinite Loop)란 끊임없이 반복되는 반복 구문을 의미합니다.
  - 코딩 테스트에서 무한 루프를 구현할 일은 거의 없으니 유의해야 합니다.
  - 반복문을 작성한 뒤에는 항상 반복문을 탈출할 수 있는지 확인합니다.

### 7.3 반복문: for문
- 반복문으로 for문을 이용할 수도 있습니다.
- for문의 구조는 다음과 같은데, 특정한 변수를 이용하여 'in'뒤에 오는 **데이터(리스트, 튜플 등)에 포함되어 있는 원소를 첫 번째 인덱스부터 차례대로 하나씩 방문**합니다.
<pre>
<code>
for 변수 in 리스트:
  실행할 소스코드
</code>
</pre>
반복문 for 예제
<pre>
<code>
array = [9, 8, 7, 6, 5]

for x in array:
    print(x)
</code>
</pre>
실행 결과
<pre>
<code>
9
8
7
6
5
</code>
</pre>

### 7.4 range()함수
- for문에서 연속적인 값을 차례대로 순회할 때는 range()를 주로 사용합니다.
  - 이때 range(시작 값, 끝 값 + 1) 형태로 사용합니다.
  - 인자를 하나만 넣으면 자동으로 시작 값은 0이 됩니다.
<pre>
<code>
result = 0

# i는 1부터 9까지의 모든 값을 순회
for i in range(1, 10):
    result += i
    
print(result)
</code>
</pre>
실행 결과
<pre>
<code>
45
</code>
</pre>

### 7.5 파이썬의 continue 키워드
- 반복문에서 남은 코드의 실행을 건너뛰고, 다음 반복을 진행하고자할 때 continue를 사용합니다.
- 1부터 9까지의 홀수의 합을 구할 때 다음과 같이 작성할 수 있습니다.
<pre>
<code>
result = 0

for i in range(1, 10):
    if i % 2 == 0:
        continue
    result += i

print(result)
</code>
</pre>
실행 결과
<pre>
<code>
25
</code>
</pre>

### 7.6 파이썬의 break 키워드
- 반복문을 즉시 탈출하고자 할 때 break를 사용합니다.
- 1부터 5까지의 정수를 차례대로 출력하고자 할 때 다음과 같이 작성할 수 있습니다.

<pre>
<code>
i = 1

while True:
    print("현재 i의 값:", i)
    if i == 5:
        break
    i += 1
</code>
</pre>
실행 결과
<pre>
<code>
현재 i의 값: 1
현재 i의 값: 2
현재 i의 값: 3
현재 i의 값: 4
현재 i의 값: 5
</code>
</pre>

### 7.7 반복문 예제
학생들의 합격 여부 판단 예제 1) 점수가 80점만 넘으면 합격
<pre>
<code>
scores = [90, 85, 77, 65, 97]

for i in range(5):
    if scores[i] >= 80:
        print(i+1, "번 학생은 합격입니다.")
</code>
</pre>
실행 결과
<pre>
<code>
1 번 학생은 합격입니다.
2 번 학생은 합격입니다.
5 번 학생은 합격입니다.
</code>
</pre>

학생들의 합격 여부 판단 예제 2) 특정 번호 학생은 제외하기
<pre>
<code>
scores = [90, 85, 77, 65, 97]
cheating_student_list = {2, 4}

for i in range(5):
    if i + 1 in cheating_student_list:
        continue
    if scores[i] >= 80:
        print(i+1, "번 학생은 합격입니다.")
</code>
</pre>
실행 결과
<pre>
<code>
1 번 학생은 합격입니다.
5 번 학생은 합격입니다.
</code>
</pre>

중첩된 반복문: 구구단 예제
<pre>
<code>
for i in range(2, 10):
    for j in range(1, 10):
        print(i, "X", j, "=", i*j)
    print()
</code>
</pre>
실행 결과
<pre>
<code>
2 X 1 = 2
2 X 2 = 4
2 X 3 = 6
2 X 4 = 8
2 X 5 = 10
2 X 6 = 12
2 X 7 = 14
2 X 8 = 16
2 X 9 = 18

3 X 1 = 3
3 X 2 = 6
3 X 3 = 9
3 X 4 = 12
3 X 5 = 15
...
(중략)
</code>
</pre>