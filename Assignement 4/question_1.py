def is_Prime(n):
    if n == 2 or n == 3:
        return f"{n} is a Prime Number"
    elif n == 1:
        return f"{n} is not a Prime Number"

    prime_test1 = (n+1)
    prime_test2 = (n-1)

    if prime_test1 % 6 == 0 or prime_test2 % 6 == 0:
        return f"{n} is a Prime Number"
    
    else:
        return f"{n} is not a Prime Number"

def Main():
    user_num = int(input("Please Enter a number to check if it is a prime number "))

    output = is_Prime(user_num)

    print(output)



Main()