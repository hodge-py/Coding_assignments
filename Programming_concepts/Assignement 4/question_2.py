import random #import the random module for use

def is_Prime(n): # n is the parameter for the function, the input from the user
    if n == 2 or n == 3 or n == 5 or n == 1 or n == 7 or n == 11: #checks the under 10 prime numbers if they are chosen
        print(f"{n} is a Prime Number")
        return 'n'
    for x in range(2,12): #loops through 2 to 9 to determine if the number is divisible
        if n % x == 0:
            print(f"{n} is not a Prime Number") #if the number is divisible, then this statement is printed
            return 'y'
    
    print(f"{n} is a Prime number") #else if the number is not divisible at all, then this statement is printed
    return 'n'

def Main():
    condition = 'y' #condition variable in which the while loop will continue to run

    while condition == 'y':
        rand_var = random.randint(1,1000) #chooses a random integer between 1 and 1000, inclusive of the end points

        condition = is_Prime(rand_var) #the loops ends if the string returned is not 'y'



Main() #runs the Main Function