import random


def check_guess(target_val):
    guess = int(input("Please guess a number between 1 and 1000: "))

    if target_val == guess:
        return 'y'
    elif guess > target_val:
        print("Too High, Try Again")
    elif guess < target_val:
        print("Too Low, Try Again")

    return 'n'


def random_gen():
    rand_int = random.randint(1,1000)

    return rand_int


def Main():
    correct = 'n'
    target_val = random_gen()
    while correct == 'n':
        correct = check_guess(target_val)
        if correct != 'n':
            target_val = random_gen()
            correct = input("To play again please enter n, else input a different character ")
    

Main()