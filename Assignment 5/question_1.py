
def integerFind(value,integers):
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]
        if ord(value[x]) in range(48,58):
            pass
        else:
            return False

    if tmp == '':
        pass
    else:
        integers.append(tmp)

    return True



def floatFind(value,floats):
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]

        if ord(value[x]) in range(48,58) or ord(value[x]) == 46:
            pass
        else:
            return False

    floats.append(tmp)

    return True

def alphabeticFind(value,alphabetic):
    tmp = ''
    for x in range(len(value)-1):
        tmp += value[x]

        if ord(value[x]) in range(65,123):
            pass
        else:
            return False

    alphabetic.append(tmp)

    return True

def alphanumFind(value,alphanum):
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
    file = open("mixeddata.txt",'r')

    integers = []
    alphabetic = []
    floats = []
    alphanum = []

    

    for x in file:
        condition = False

        condition = integerFind(x,integers)

        if condition == False:
            condition = floatFind(x,floats)

        if condition == False:
            condition = alphabeticFind(x,alphabetic)
        
        if condition == False:
            condition = alphanumFind(x,alphanum)



    print(integers,floats,alphabetic,alphanum)



Main()