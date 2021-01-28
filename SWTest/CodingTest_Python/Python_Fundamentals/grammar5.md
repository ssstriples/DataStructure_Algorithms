# 코딩 테스트 노트 with Python

## 2. 파이썬 문법

### 5.1 기본 입출력
- 모든 프로그램은 적절한(약속된) 입출력 양식을 가지고 있습니다.
- 프로그램 동작의 첫 번째 단계는 데이터를 입력 받거나 생성하는 것입니다.
- 예시) 학생의 성적 데이터가 주어지고, 이를 내림차순으로 정렬한 결과를 출력하는 프로그램

  입력 예시
  <pre>
  <code>
  5
  65 90 75 34 99
  </code>
  </pre>

  출력 예시
  <pre>
  <code>
  99 90 75 65 34
  </code>
  </pre>

### 5.2 자주 사용되는 표준 입력 방법
- input() 함수는 *한 줄의 문자열을 입력 받는 함수*입니다.
- map() 함수는 *리스트의 모든 원소에 각각 특정한 함수를 적용할 때 사용*합니다.
- 예시) 공백을 기준으로 구분된 데이터를 입력 받을 때는 다음과 같이 사용합니다.
  - list(map(int, input().split()))
- 예시) 공백을 기준으로 구분된 데이터의 개수가 많지 않다면, 단순히 다음과 같이 사용합니다.
  - a, b, c = map(int, input().split())

<pre>
<code>
# 데이터의 개수 입력
n = int(input())

# 각 데이터를 공백을 기준으로 구분하여 입력
data = list(map(int, input().split()))

data.sort(reverse = True)
print(data)
</code>
</pre>
실행 결과
<pre>
<code>
5
65 90 75 34 99
[99, 90, 75, 65, 34]
</code>
</pre>

### 5.3 빠르게 입력 받기
- 사용자로부터 **입력을 최대한 빠르게 받아야 하는 경우**가 있습니다.
- 파이썬의 경우 sys 라이브러리에 정의되어 있는 sys.stdin.readline() 메서드를 이용합니다.
  - 단, 입력 후 엔터(Enter)가 줄 바꿈 기호로 입력되므로 rstrip() 메서드를 함꼐 사용합니다.

<pre>
<code>
import sys

# 문자열 입력 받기
data = sys.stdin.readline().rstrip()
print(data)
</code>
</pre>

### 5.4 자주 사용되는 표준 출력 방법
- 파이썬에서 기본 출력은 print() 함수를 이용합니다.
  - 각 변수를 콤마(,)를 이용하여 띄어쓰기로 구분하여 출력할 수 있습니다.
- print()는 기본적으로 출력 이후에 줄 바꿈을 수행합니다.
  - 줄 바꿈을 원치 않는 경우 'end' 속성을 이용할 수 있습니다.

<pre>
<code>
# 출력할 변수들
a = 1
b = 2
print(a, b)
print(7, end=" ")
print(8, end=" ")

# 출력할 변수
answer = 7
print("정답은 " + str(answer) + "입니다.")
</code>
</pre>
실행 결과
<pre>
<code>
1 2
7 8 정답은 7입니다.
</code>
</pre>

### 5.5 f-String 예제
- 파이썬 3.6부터 사용 가능하며, 문자열 앞에 접두사 'f'를 붙여 사용합니다.
- 중괄호 안에 변수명을 기입하여 간단히 문자열과 정수를 함께 넣을 수 있습니다.

<pre>
<code>
answer = 7
print(f"정답은 {answer}입니다.")
</code>
</pre>
실행 결과
<pre>
<code>
정답은 7입니다.
</code>
</pre>