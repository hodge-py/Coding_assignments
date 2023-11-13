import random #import the random module for use


def check_guess(target_val):
<<<<<<< HEAD
    guess = input("Please guess a number between 1 and 1000: ") #user inputs a number between 1 and 1000

    if guess == '': #input validation, checks if user entered a number
        print("Please Enter a number")
        return 'n'
    
    guess = int(guess)
=======
    guess = int(input("Please guess a number between 1 and 1000: ")) #user inputs a number between 1 and 1000
>>>>>>> parent of 4ee1b32 (changes)
    
    if guess < 1 or guess > 1000: #insures the input is valid for the function
        print("Invalid input, Please input a value between 1 and 1000")
    elif target_val == guess: 
        return 'y' # if the guess is correct then 'y' is returned and the loop ends
    elif guess > target_val:
        print("Too High, Try Again") #prints if the guess is too high
    elif guess < target_val:
        print("Too Low, Try Again") #prints if the guess is too low

    return 'n' #returns 'n' to continue the while loop


def random_gen():
    rand_int = random.randint(1,1000) #generates a random integer between 1 and 1000

    return rand_int # returns the variable for use


def Main():
    correct = 'n' #condition for the while loop
    target_val = random_gen() #generates the random number the user must guess
    while correct == 'n': 
        correct = check_guess(target_val) #the return value will be inserted to correct
        if correct != 'n': # if 'y' is returned then the loop ends, a new target value is generated and it asks the used if they want to play again
            target_val = random_gen()
            correct = input("To play again please enter n, else input a different character ")
    

Main() #runs the Main Function