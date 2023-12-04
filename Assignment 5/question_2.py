def nameCheck():
    name = input("Enter Name ")
    for x in name:
        if ord(x) not in range(65,123):
            return ''
    return name

def ageCheck():
    age = input("Enter Age ")
    print(age)
    for x in age:

        if ord(x) not in range(48,58):
            return ''
    return age

def idCheck():
    id = input("Enter ID ")
    for x in id:
        if ord(x) not in range(48,58):
            return ''
    return id

def serviceCheck():
    service = input("Enter Years of Service ")
    for x in service:
        if ord(x) not in range(48,58):
            return ''
    return service


def main():
    name = ''
    age = ''
    id = ''
    service = ''
    file = open('employeedb.txt', 'w')

    records = int(input("Number of Records to enter "))

    for x in range(records):
        while name == '':
            name = nameCheck()

        while age == '':
            age = ageCheck()

        while id == '':
            id = idCheck()
        
        while service == '':
            service = serviceCheck()


        print(f"Record {x+1} Entry Successful")
        print(name,age,id,service)


main()