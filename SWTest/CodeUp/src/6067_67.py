a = int(input())

if a < 0:
    if not (a%2):
        print('A')
    else:
        print('B')
else:
    if not (a%2):
        print('C')
    else:
        print('D')