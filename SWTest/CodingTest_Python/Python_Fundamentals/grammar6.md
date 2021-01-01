# 코딩 테스트 노트 with Python

## 2. 파이썬 문법

### 6.1 조건문
- 조건문은 **프로그램의 흐름을 제어하는 문법**입니다.
- 조건문을 이용해 조건에 따라서 프로그램의 로직을 설정할 수 있습니다.

조건문 예제
<pre>
<code>
x = 15

if x >= 10:
    print("x >= 10")

if x >= 0:
    print("x >= 0")

if x >= 30:
    print("x >= 30")
</code>
</pre>
실행 결과
<pre>
<code>
x >= 10
x >= 0
</code>
</pre>

### 6.2 들여쓰기
- 파이썬에서 코드의 블록(Block)을 들여쓰기(Indent)로 지정합니다.
- 다음의 코드에서 2번 라인은 무조건 실행됩니다.
- 탭을 사용하는 쪽과 공백 문자(space)를 여러 번 사용하는 쪽으로 두 진영이 있습니다.
  - 이에 대한 논쟁은 지금까지도 활발합니다.
- 파이썬 스타일 가이드라인에서는 **4개의 공백 문자를 사용하는 것을 표준으로 설정**하고 있습니다.

<pre>
<code>
score = 85

if score >= 70:
    print('성적이 70점 이상입니다.')
    if score >= 90:
        print('우수한 성적입니다.')

else:
    print('성적이 70점 미만입니다.')    # 1
    print('조금 더 분발하세요.')        # 1

print('프로그램을 종료합니다.') # 2
</code>
</pre>
실행 결과
<pre>
<code>
성적이 70점 이상입니다.
프로그램을 종료합니다.
</code>
</pre>

### 6.3 조건문의 기본 형태
- 조건문의 기본적인 형태는 **if ~ elif ~ else** 입니다.
  - 조건문을 사용할 때 elif 혹은 else 부분은 경우에 따라서 사용하지 않아도 됩니다.
  <pre>
  <code>
  if 조건문 1:
    조건문 1이 True일 때 실행되는 코드
  elif 조건문 2:
    조건문 1에 해당하지 않고, 조건문 2가 True일 때 실행되는 코드
  else:
    위의 모든 조건문이 모두 True 값이 아닐 때 실행되는 코드   
  </code>
  </pre>

성적 구간에 따른 학점 출력 예제
<pre>
<code>
score = 85

if score >= 90:
    print("학점: A")
elif score >= 80:
    print("학점: B")
elif score >= 70:
    print("학점: C")
else:
    print("학점: F")
</code>
</pre>
실행 결과
<pre>
<code>
학점: B
</code>
</pre>

### 6.4 비교 연산자
- 비교 연산자는 특정한 두 값을 비교할 때 이용할 수 있습니다.
  - 대입 연산자(=)와 같음 연산자(==)의 차이점에 유의하세요.

|비교 연산자|설명|
|:---:|:---:|
|X == Y|X와 Y가 서로 같을 때 참(True)이다.|
|X != Y|X와 Y가 서로 다를 때 참(True)이다.|
|X > Y|X가 Y보다 클 때 참(True)이다.|
|X < Y|X가 Y보다 작을 때 참(True)이다.|
|X >= Y|X가 Y보다 크거나 같을 때 참(True)이다.|
|X <= Y|X가 Y보다 작거나 같을 때 참(True)이다.|

### 6.5 논리 연산자
- 논리 연산자는 **논리 값(True/False) 사이의 연산**을 수행할 때 사용합니다.

|논리 연산자|설명|
|:---:|:---:|
|X and Y|X와 Y가 모두 참(True)일 때 참(True)이다.|
|X or Y|X와 Y 중에 하나만 참(True)이어도 참(True)이다.|
|not X|X가 거짓(False)일 때 참(True)이다.|

### 6.6 파이썬의 기타 연산자
- 다수의 데이터를 담는 자료형을 위해 in 연산자와 not in 연산자가 제공됩니다.
	- 리스트, 튜플, 문자열, 딕셔너리 모두에서 사용이 가능합니다.

|in 연산자와 not in 연산자|설명|
|:---:|:---:|
|X in 리스트|리스트 안에 X가 들어가 있을 때 참(True)이다.|
|X not in 문자열|문자열 안에 X가 들어가 있지 않을 때 참(True)이다.|

### 6.7 파이썬의 pass 키워드
- 아무것도 처리하고 싶지 않을 때 pass 키워드를 사용합니다.
- 예시) 디버깅 과정에서 일단 조건문의 형태만 만들어 놓고 조건문을 처리하는 부분은 비워놓고 싶은 경우

<pre>
<code>
score = 85

if score >= 80:	
	pass # 나중에 작성할 소스코드
else:
	print('성적이 80점 미만입니다.')
print('프로그램을 종료합니다.')
</code>
</pre>


### 6.8 조건문의 간소화
- 조건문에서 실행될 소스코드가 한 줄인 경우, 굳이 줄 바꿈을 하지 않고도 간략하게 표현할 수 있습니다.
<pre>
<code>
score = 85

if score >= 80: result = "Success"
else: result = "Fail"
</code>
</pre>
- 조건부 표현식(Conditional Expression)은 **if ~ else문을 한 줄에 작성**할 수 있도록 해줍니다.
<pre>
<code>
score = 85
result = "Success" if score >= 80 else "Fail"
print(result)
</code>
</pre>

### 6.9 파이썬 조건문 내에서의 부등식
- 다른 프로그래밍 언어와 다르게 파이썬은 조건문 안에서 수학의 부등식을 그대로 사용할 수 있습니다.
- 예를 들어 **x > 0 and x < 20**과 **0 < x < 20**은 같은 결과를 반환 합니다.
<pre>
<code>
# 코드 스타일 1
x = 15
if x > 0 and x < 20:
	print("x는 0초과 20미만의 수입니다.")
</code>
</pre>
<pre>
<code>
# 코드 스타일 2
x = 15
if 0 < x < 20:
	print("x는 0초과 20미만의 수입니다.")
</code>
</pre>
- 다른 언어를 다룰 때 헷갈리지 않도록 **x > 0 and x < 20**와 같이 비교 연산자 사이에 and, or 등의 연산자가 들어가는 형태의 코드를 이용합니다.