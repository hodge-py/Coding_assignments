import random

subsetsum = 0 #global variable that will be used

def add(): #function to add up the random values
    global subsetsum #global keyword to access the variable
    next_rand = randomgen() #generates a random integer to add to the total value
    subsetsum += next_rand

    if subsetsum == 0: #if subsetsum reaches zero, prints that zero is reached and returns 'n' that will end the loop
        print("Value is zero, END")
        return 'n'

    print(f"The value is now {subsetsum}")
    return 'y'

def randomgen():
    rand = random.randint(-25,25)

    return rand

def Main():
    
    condition = 'y'

    while condition == 'y':
        condition = add() 



Main()