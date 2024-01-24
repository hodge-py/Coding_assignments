proceed = 'y' ##set the while loop condition

while(proceed == 'y'): ## will continue to loop until the condition is false - try and except used for input validation
    
        num1 = input("Please enter a number ") ## ask user to enter a number and then convert to int
        num2 = input("Please enter another number ")
        
        num1 = int(num1) ##convert to int
        num2 = int(num2)    
        total = num1 + num2 ## add the numbers together

        print(total) ##print the total

        proceed = input("Please type y to enter new numbers or any other characters to stop the loop ") ## ask the user if they wish to add new numbers together or to exit the loop

    