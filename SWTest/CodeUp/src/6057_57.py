a, b = map(bool, map(int, input().split()))

print((a and b) or (not a and not b))