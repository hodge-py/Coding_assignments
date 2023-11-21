
subsetsum = 0 #global variable that will be used

def add(value): #function to add up the values
    global subsetsum #global keyword to access the variable
    subsetsum += value #generates a random integer to add to the total value

    if subsetsum == 0: #the sum is zero then 'n' is returned and the loop ends
        return 'n'

    return 'y' #return 'y' and keep the loop running if the sum is not zero

def Main():
    
    condition = 'y'

    while condition == 'y':
        is_number = 'yes'
        
        val_1 = input("Please enter a number between -10 and 10 ") #User Inputs a value that is converted from string to int

        for x in val_1: #this works by looping through the string, if any of of characters are not a valid unicode number than zero is returned and the statement is printed
            if ord(x) not in range(48, 58) and ord(x) != 45:
                is_number = 'no'
            elif ord(x) == 45 and len(val_1) == 1: #checks if the user just entered a minus sign and nothing else
                is_number = 'no'
            else:
                pass
        

        if is_number == 'yes':
            if int(val_1) > 10 or int(val_1) < -10: #checks if the inputted value is between 10 and -10, exclusively
                print("Error, please enter a valid value")
            else: #if input passes checks then it continues on to the function
                val_1 = int(val_1)
                condition = add(val_1)
        else:
            print("Not a number, please enter a valid number")




Main()
