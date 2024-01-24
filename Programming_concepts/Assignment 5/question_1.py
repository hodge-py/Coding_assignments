
def integerFind(value,integers):
    tmp = ''
    for x in range(len(value)-1): #loops through every character
        tmp += value[x]
        if ord(value[x]) in range(48,58): # if the character is in the range of 48 to 57 then it continues
            pass
        else:
            return False #return false if the value is not in the range.

    if tmp == '':
        pass
    else: # if tmp is not empty then append the full value to integers
        integers.append(int(tmp))

    return True



def floatFind(value,floats): #the other functions work in a similar way as the first function just with a different ord() constraint.
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]

        if ord(value[x]) in range(48,58) or ord(value[x]) == 46:
            pass
        else:
            return False

    floats.append(float(tmp))

    return True

def alphabeticFind(value,alphabetic): #the other functions work in a similar way as the first function just with a different ord() constraint.
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]

        if ord(value[x]) in range(65,123):
            pass
        else:
            return False

    alphabetic.append(tmp)

    return True

def alphanumFind(value,alphanum): #the other functions work in a similar way as the first function just with a different ord() constraint.
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]

        if ord(value[x]) in range(65,123) or ord(value[x]) in range(48,58) or ord(value[x]) == 46:
            pass
        else:
            return False

    alphanum.append(tmp)

    return True



def Main():
    file = open("mixeddata.txt",'r') #open the file in read mode

    integers = [] #empty lists to store the values into.
    alphabetic = []
    floats = []
    alphanum = []

    

    for x in file: # loop through each line in the file
        condition = False

        condition = integerFind(x,integers) # the order of functions is int,float,alpha,alphanum.

        if condition == False:
            condition = floatFind(x,floats) #once a character doesnt fit the criteria the function returns false and moves onto the next function

        if condition == False:
            condition = alphabeticFind(x,alphabetic)
        
        if condition == False:
            condition = alphanumFind(x,alphanum)



    print(f' List of Integer: {integers}\n',f"List of Floating Points: {floats}\n",f"List of strings: {alphabetic}\n",f"List of alphanumerics: {alphanum}\n") #print the lists after looping through the file



Main() #runs the file