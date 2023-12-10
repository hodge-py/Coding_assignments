import math

def splitter(mainL,serial,name,age,id,rate): #function used to split the file into different groups
    for x in mainL:
        count = 0
        for y in range(len(x)): #this is done by using a nested loop and then knowing how many steps are necessary for each group
            if count == 0:
                serial += [int(x[y])]
                count += 1
            elif count == 1: # name is always at the 1 index of the array. age is 2 index of the array and etc.
                name += [x[y]]
                count += 1
            elif count == 2:
                age += [int(x[y])]
                count += 1
            elif count == 3:
                id += [x[y]]
                count += 1
            else:
                rate += [float(x[y])]



def write_to_file(age,rate): #function for writing the statistical data to the file
    data = open('datastats.txt','w') #opens the file in write mode

    meanAge = sum(age)/len(age) #mean age
    data.write("Average age of employees: " + str(meanAge) + '\n') #writes it to file
    maxRate = max(rate) #max rate
    data.write("Highest pay rate of employee: " + str(maxRate)  + '\n')
    minRate = min(rate) #min rate
    data.write("Lowest pay rate of employee: " + str(minRate) + '\n')
    aveRate = sum(rate)/len(rate) #average rate
    data.write("Average pay rate of employee: " + str(aveRate) + '\n')


def Main():
    file = open('data.txt', 'r') #opens the file in read mode
    count = 0
    mainL = []
    title = []
    
    serial = [] #empty lists to store values
    name = []
    age = []
    id = []
    rate = []


    for x in file: # skips the first two lines since that is the title and dotted line.
        if count == 0:
            count += 1
        elif count == 1:
            count += 1
        else:
            mainL.append(x.split(" ")) #this then splits the file by spaces and then appends it to a master list
    
    
    splitter(mainL,serial,name,age,id,rate) #each list is used a parameter in the function so they have access

    
    print(f" Name of Employee: {name}\n",f"Age: {age}\n",f"ID: {id}\n",f"Rate: {rate}\n") #prints the list after the splitter function runs


    write_to_file(age,rate) #Write the averages and max/min to the file. Age and rate are inserted as parameters
    


    



Main() #runs the file