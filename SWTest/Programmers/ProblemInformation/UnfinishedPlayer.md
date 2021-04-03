# 1. 완주하지 못한 선수
## 1.1. 문제 설명
- 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

- 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 떄, 완주하지 못한 선수의 이름을 return하도록 solution함수를 작성해주세요.

## 1.2. 제한 사항
- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.

## 1.3. 입출력 예

|participant|completion|return|
|:---:|:---:|:---:|
|["leo", "kiki", "eden"]|["eden", "kiki"]|"leo"|
|["marina", "josipa", "nikola", "vinko", "filipa"]|["josipa", "filipa", "marina", "nikola"]|"vinko"|
|["mislav", "stanko", "mislav", "ana"]|["stanko", "ana", "mislav"]|"mislav"|


### 1.4. 입출력 예 설명
#### 예제 #1
- "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

#### 예제 #2
- "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

#### 예제 #3
- "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 떄문에 한명은 완주하지 못했습니다.

## 1.4 Code
<pre>
<code>
# Hash1 : 완주하지 못한 선수

def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for p, c in zip(participant, completion):
        if p != c:
            return p

    return participant.pop()

participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]

print(solution(participant, completion))
</code>
</pre>

## 1.5 문제해결 아이디어
- 

## 1.6 다른 사람의 풀이
- https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=python3
<pre>
<code>
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
</code>
</pre>