import math



def splitter(mainL,serial,name,age,id,rate):
    for x in mainL:
        count = 0
        for y in range(len(x)):
            if count == 0:
                serial += [int(x[y])]
                count += 1
            elif count == 1:
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



def write_to_file(age,rate):
    data = open('datastats.txt','w')

    meanAge = sum(age)/len(age)
    data.write("Average age of employees: " + str(meanAge) + '\n')
    maxRate = max(rate)
    data.write("Highest pay rate of employee: " + str(maxRate)  + '\n')
    minRate = min(rate)
    data.write("Lowest pay rate of employee: " + str(minRate) + '\n')
    aveRate = sum(rate)/len(rate)
    data.write("Average pay rate of employee: " + str(aveRate) + '\n')


def Main():
    file = open('data.txt', 'r')
    count = 0
    mainL = []
    title = []
    
    serial = []
    name = []
    age = []
    id = []
    rate = []


    for x in file:
        if count == 0:
            count += 1
        elif count == 1:
            count += 1
        else:
            mainL.append(x.split(" "))
    
    
    splitter(mainL,serial,name,age,id,rate)

    
    print(name,age,id,rate)


    write_to_file(age,rate)
    


    



Main()