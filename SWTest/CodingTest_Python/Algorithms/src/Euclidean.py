def GCD_EUCLIDEAN(a, b):
    
    if a % b == 0:
        return b
    else: 
        return GCD_EUCLIDEAN(b, a % b)

print(GCD_EUCLIDEAN(192, 162))