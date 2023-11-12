
def is_Prime(n): # n is the parameter for the function, the input from the user
    if n < 1: #input validation, to check if the number is less than one
        return "Prime Numbers are greater than 0, please enter a valid input"
    if n == 2 or n == 3 or n == 5 or n == 1 or n == 7 or n == 11: #checks the known prime numbers if they are chosen
        return f"{n} is a Prime Number"
    for x in range(2,12): #loops through 2 to 9 to determine if the number is divisible
        if n % x == 0:
            return f"{n} is not a Prime Number" #if the number is divisible, this statement is returned
    
    return f"{n} is a Prime number" #else if the number is not divisible at all, then this statement is returned

def Main():
    user_num = input("Please Enter a number to check if it is a prime number ") #user inputs a number and that is converted from str to int

    if user_num == '': #input validation, checks if user entered a number
        print("Please enter a number and not blank")
        return 0
    else:
        user_num = int(user_num)


    output = is_Prime(user_num) #this is the function to determine if the number inputted was a prime number, a statement is returned

    print(output) #prints the statement that was returned from the is_Prime function



Main() #runs the Main function