
def factorial(value): ## function to calculate a factorial if the input is a non-negative
    total = 1
    if(value < 0): ## if the value is negative this will print instead of returning a value
        print("Negative number, only non-negative is valid")
        return -1
    else: ## if the value is positive, loop through range and multiple the numbers
        for x in range(1,value+1):
            total *= x
        return total 

number = int(input("Please Enter a non-negative number ")) ##user enters a number and it is converted from string to int
end_value = factorial(number) ## use the users input as a parameter for the function

if(end_value == -1): ##function returns -1 if a negative number is inputted so nothing is done
    pass
else: ## if the value is assigned, print the resulting value from the factorial function
    print(end_value)
