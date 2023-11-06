import random


def check_guess(target):
    pass


def random_gen():
    rand_int = random.randint(0,1000)

    return rand_int


def Main():
    target_val = random_gen()

    check_guess(target_val)