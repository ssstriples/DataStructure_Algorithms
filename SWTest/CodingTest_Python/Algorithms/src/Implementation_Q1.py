# Implementation Practice #1 : 시각

# H 입력 받기
h = int(input())

count = 0

for i in range(h + 1):
    for j in range(60):
        for k in range(60):
            # 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
            timebs = str(i) + str(j) + str(k)
            if '3' in timebs:
                count += 15
print(count)