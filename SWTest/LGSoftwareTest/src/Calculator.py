N = int(input())
# B S D를 저장하기 위한 임시 List(int, string, string)
line = list()
B = 0
S = list()
D = list()
# Digit to Char ascii
d2c = list("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")

def c2d(ch):
    return d2c.index(ch)

def mul(s, d):
    alen = len(S) - s
    blen = len(D) - d
    tlen = alen + blen - 1
    AA = list()
    BB = list()
    sol = [0 for i in range(tlen)]

    for i in range(0, alen):
        AA.append(c2d(S[i+s]))
    for i in range(0, blen):
        BB.append(c2d(D[i+d]))

    for i in range(0, alen):
        for j in range(0, blen):
            sol[i + j] += AA[i] * BB[j]
    # print(sol)

    for i in range(tlen -1, 0, -1):
        if sol[i] >= B:
            sol[i - 1] += sol[i] // B
            sol[i] %= B
    if sol[0] >= B:
        print(d2c[sol[0] // B], end='')
        sol[0] %= B
    for i in range(tlen):
        print(d2c[sol[i]], end='')
    print()

def solve():
    if S[0] == '0' or D[0] == '0':
        print("0")
        return
    sign = 1
    s = d = 0
    if S[0] == '-':
        sign *= -1
        s+=1
    if D[0] == '-':
        sign *= -1
        d+=1
    if sign < 0:
        print("-", end='')
    mul(s, d)

for i in range(N):
    line = list(input().split())
    B = int(line[0])
    S = list(line[1])
    D = list(line[2])
    solve()