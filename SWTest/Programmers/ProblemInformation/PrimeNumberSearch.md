# 1. 소수 찾기
## 1.1. 문제 설명
- 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

- 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇개인지 return하도록 solution함수를 완성해주세요.

## 1.2. 제한 사항
- numbers는 길이 1이상 7이하인 문자열입니다.
- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
- "013"은 0, 1, 3숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

## 1.3. 입출력 예

|numbers|return|
|:---:|:---:|
|"17"|3|
|"011"|2|

### 1.4. 입출력 예 설명
#### 예제 #1
- [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

#### 예제 #2
- [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
    - 11과 011은 같은 숫자로 취급합니다.

## 1.4 Code
<pre>
<code>
# 완전탐색1 : 소수찾기
from itertools import permutations
import math

def isPrime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    result = []
    
    for i in range(1, len(numbers) + 1):
        perlist = list(map(''.join, permutations(numbers, i)))
        # print(perlist)
        for j in list(set(perlist)):
            result.append(int(j))
        print(result)

    for num in list(set(result)):
        if num == 0 or num == 1:
            continue
        if isPrime(num):
            answer +=1
    return answer

print(solution(input()))
</code>
</pre>

## 1.5 문제해결 아이디어
- 

## 1.6 다른 사람의 풀이
- https://programmers.co.kr/learn/courses/30/lessons/42839/solution_groups?language=python3