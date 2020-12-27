# 코딩 테스트 노트 with Python

## 2. 파이썬 문법

### 4.1 사전 자료형
- 사전 자료형은 **키(Key)와 값(Value)의 쌍을 데이터로 가지는 자료형**입니다.
  - 앞서 다루었던 리스트나 튜플이 값을 순차적으로 저장하는 것과는 대비됩니다.
- 사전 자료형은 키와 값의 쌍을 데이터로 가지며, 원하는 **'변경 불가능한(Immutable) 자료형'**을 키로 사용할 수 있습니다.
- 파이썬의 사전 자료형은 해시 테이블(Hash Table)을 이용하므로 *데이터의 조회 및 수정에 있어서 O(1)의 시간에 처리*할 수 있습니다.

  |키(Key)|값(Value)|
  |:---:|:---:|
  |사과|Apple|
  |바나나|Banana|
  |코코넛|Coconut|

<pre>
<code>
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

print(data)

if '사과' in data:
    print("'사과'를 키로 가지는 데이터가 존재합니다.")
</code>
</pre>

실행 결과
<pre>
<code>  
{'사과': 'Apple', '바나나': 'Banana', '코코넛': 'Coconut'}
'사과'를 키로 가지는 데이터가 존재합니다.
</code>
</pre>

### 4.2 사전 자료형 관련 메서드
- 사전 자료형에서는 키와 값을 별도로 뽑아내기 위한 메서드를 지원합니다.
  - 키 데이터만 뽑아서 리스트로 이용할 때는 **keys()함수**를 이용합니다.
  - 값 데이터만 뽑아서 리스트로 이용할 때는 **values()함수**를 이용합니다.

<pre>
<code>
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

# 키 데이터만 담은 리스트
key_list = data.keys()
# 값 데이터만 담은 리스트
value_list = data.values()
print(key_list)
print(value_list)

# 각 키에 따른 값을 하나씩 출력
for key in key_list:
    print(data[key])
</code>
</pre>

실행 결과
<pre>
<code>
dict_keys(['사과', '바나나', '코코넛'])
dict_values(['Apple', 'Banana', 'Coconut'])
Apple
Banana
Coconut
</code>
</pre>
사전 자료형 사용 예제
<pre>
<code>
a = dict()
a['홍길동'] = 97
a['이순신'] = 98

print(a)

b = {
    '홍길동' : 97,
    '이순신' : 98
}

print(b)
print(b['이순신'])

key_list = list(b.keys())
print(key_list)
</code>
</pre>

### 4.3 집합 자료형
- 집합은 다음과 같은 특징이 있습니다.
  - 중복을 허용하지 않습니다.
  - 순서가 없습니다.
- 집합은 **리스트 혹은 문자열을 이용해서 초기화**할 수 있습니다.
  - 이때 set()함수를 이용합니다.
- 혹은 중괄호({})안에 각 원소를 콤마(,)를 기준으로 구분하여 삽입함으로써 초기화 할 수 있습니다.
- *데이터의 조회 및 수정에 있어서 O(1)의 시간에 처리*할 수 있습니다.

<pre>
<code>
# 집합 자료형 초기화 방법  1
data = set([1, 1, 2, 3, 4, 4, 5])
print(data)

# 집합 자료형 초기화 방법 2
data = {1, 1, 2, 3, 4, 4, 5}
print(data)
</code>
</pre>
실행 결과
<pre>
<code>
{1, 2, 3, 4, 5}
{1, 2, 3, 4, 5}
</code>
</pre>

### 4.4 집합 자료형의 연산
- 기본적인 집합 연산으로는 합집합, 교집합, 차집합 연산 등이 있습니다.
  - 합집합 : 집합 A에 속하거나 B에 속하는 원소로 이루어진 집합(A ∪ B)
  - 교집합 : 집합 A에도 속하고 B에도 속하는 원소로 이루어진 집합(A ∩ B)
  - 차집합 : 집합 A의 원소 중에서 B에 속하지 않는 원소들로 이루어진 집합(A - B)

<pre>
<code>
a = set([1, 2, 3, 4 ,5])
b = set([3, 4 ,5 ,6 ,7])

# 합집합
print(a | b)

# 교집합
print(a & b)

# 차집합
print(a - b)
</code>
</pre>
실행 결과
<pre>
<code>
{1, 2, 3, 4, 5, 6, 7}
{3, 4, 5}
{1, 2}
</code>
</pre>
집합 자료형 관련 함수
<pre>
<code>
data = set([1, 2, 3])
print(data)

# 새로운 원소 추가
data.add(4)
print(data)

# 새로운 원소 여러 개 추가
data.update([5, 6])
print(data)

# 특정한 값을 갖는 원소 삭제
data.remove(3)
print(data)
</code>
</pre>
실행 결과
<pre>
<code>
{1, 2, 3}
{1, 2, 3, 4}
{1, 2, 3, 4, 5, 6}
{1, 2, 4, 5, 6}
</code>
</pre>

### 4.5 사전 자료형과 집합 자료형의 특징
- 리스트나 튜플은 순서가 있기 때문에 인덱싱을 통해 자료형의 값을 얻을 수 있습니다.
- 사전 자료형과 집합 자료형은 순서가 없기 때문에 인덱싱으로 값을 얻을 수 없습니다.
  - 사전의 키(Key) 혹은 집합의 원소(Element)를 이용해 O(1)의 시간 복잡도로 조회합니다.