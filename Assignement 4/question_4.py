
subsetsum = 0

def add(value):
    global subsetsum
    subsetsum += value

    if subsetsum == 0:
        return 'n'

    return 'y'

def Main():
    
    condition = 'y'

    while condition == 'y':
        val_1 = int(input("Please enter a number between -10 and 10 ")) #User Inputs a value that is converted from string to int
        
        condition = add(val_1) 




Main()
