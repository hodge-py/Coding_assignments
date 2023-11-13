
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
        val_1 = input("Please enter a number between -10 and 10 ") #User Inputs a value that is converted from string to int

        if val_1.isdigit() == False: #input check, determines if a value was inputted
            print("Error, please enter a value")
        elif int(val_1) > 10 or int(val_1) < -10: #checks if the inputted value is between 10 and -10, exclusively
            print("Error, please enter a valid value")
        else: #if input passes checks then it continues on to the function
            val_1 = int(val_1)
            condition = add(val_1) 




Main()
