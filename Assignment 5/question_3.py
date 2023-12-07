



def splitter(x):
    pass



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
    
    
    for x in mainL:
        count = 0
        for y in range(len(x)):
            print(x[y])
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

    
    print(serial,name,age,id,rate)


        

    



Main()