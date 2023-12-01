
def integerFind(value,integers):
    tmp = ''
    for x in range(len(value)-1):
        print(x)
        tmp += value[x]
        if ord(value[x]) not in range(48,58):
            return False
        
    integers.append(tmp)


def floatFind(value,floats):
    tmp = ''
    for x in range(len(value)-1):
        print(x)
        tmp += value[x]

        if ord(value[x]) not in range(48,58) and ord(value[x]) != 46:
            return False

    floats.append(tmp)

def alphabeticFind(value):
    pass

def alphanumFind(value):
    pass


def Main():
    file = open("mixeddata.txt",'r')

    integers = []
    alphabetic = []
    floats = []
    alphanum = []

    condition = ''

    for x in file:
        print(x)
        
        integerFind(x,integers)

        #floatFind(x,floats)



    print(integers,floats)




    



Main()