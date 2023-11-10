import random

subsetsum = 0

def add():
    global subsetsum
    next_rand = randomgen()
    subsetsum += next_rand

    if subsetsum == 0:
        print("Value is zero, END")
        return 'n'

    print(f"The value now is {subsetsum}")
    return 'y'

def randomgen():
    rand = random.randint(-25,25)

    return rand

def Main():
    
    condition = 'y'

    while condition == 'y':
        #val_1 = int(input("Press Enter to continue ")) #User Inputs a value that is converted from string to int
        
        condition = add() 




Main()