total = 0 ##total after added
zero = 0 ## starting variable for numerator
thirty = 31 ##Starting variable for denominator

for x in range(0,30): ## loop through using the range function, 0 is inclusion and 30 is exclusive. total loops is 30. 
    zero += 1
    thirty -= 1
    total += zero/thirty

## Add one to numerator and minus one for the denominator than divided them.

print(total) ## print final value after loop