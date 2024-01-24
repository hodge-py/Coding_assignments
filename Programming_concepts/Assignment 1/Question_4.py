space = '' ## the space that will be added between the hashmarks

for x in range(0,6): ## need to loop 6 times to draw 6 rows
    if(x > 0): ## after zero, the loop will added a space between them
        space += ' '
    for y in range(0,1): ## print the the statement including a space 
        print('#' + space + '#')
