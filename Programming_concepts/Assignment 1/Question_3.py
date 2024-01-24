
time = int(input("How many hours has it traveled? ")) ## ask the user to enter how long the trip will take and converts it to int
speed = int(input("What is the speed of the vehicle in mph? ")) ## ask the user to enter how fast the vehicle will be traveling and converts it to int

if(time <= 0 or speed <= 0): 
    print("Time and Speed must be greater than 0")
else:
    print("Hour     Distance Traveled") ##print the title for the table
    print("__________________________") ##print the bar under the title

    for x in range(1,time+1): ##loop through using a for loop using the range function setting the starting number as 1 and then end value as the time plus 1 to include the last number of time
        print(f'{x}             {x*speed}')

