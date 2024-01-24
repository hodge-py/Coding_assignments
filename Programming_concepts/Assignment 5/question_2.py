def nameCheck():
    name = input("Enter Name ") #name is inputted
    for x in name:
        if ord(x) not in range(65,123): #loops through input and if it is not in the range reset the loop
            print("Invalid Name")
            return ''
    return name #return name if it passes the condition, if not the other functions are checked

def ageCheck():
    age = input("Enter Age ")
    for x in age:
        if ord(x) not in range(48,58):
            print("invalid Age")
            return ''
    return age

def idCheck(): #similar idea for the rest of the functions. Checks if in range and then adds it to its respected list if valid
    id = input("Enter ID ")
    for x in id:
        if ord(x) not in range(48,58) and ord(x) not in range(65,123):
            print("Invalid ID")
            return ''
    return id

def serviceCheck():
    service = input("Enter Years of Service ")
    for x in service:
        if ord(x) not in range(48,58):
            print("Invalid Service Year")
            return ''
    return service

def test_records(records):
    for x in records:
        if ord(x) not in range(49,58):
            print("Invalid Record")
            return ''
        else:
            pass
    return 'complete'

def main():
    
    file = open('employeedb.txt', 'w') #open the employeedb.txt file in write mode
    
    file.write("{:<20} {:<20} {:<20} {:<20} {:<20}\n".format('Serial Number','Name of Employee','Age','Employee ID','Years of Service')) #write the columns, with formating of 20 spaces
    file.write("-"*100 + '\n') #write the line by multiplying by 100

    
    test = ''
    while test == '':
        records = input("Number of Records to enter ") #if the input passes the condition then the while loop will end
        test = test_records(records)

        
    
    records = int(records) #convert to int since the value is valid

    for x in range(records): #use the range function to loop through the necessary amount of records
        name = ''
        age = ''
        id = ''
        service = ''
        print(f"Entering Record {x+1}")
        while name == '':
            name = nameCheck() #if Valid, return the value and set it to name. Do the same for the rest of the options

        while age == '':
            age = ageCheck()

        while id == '':
            id = idCheck()
        
        while service == '':
            service = serviceCheck()


        print(f"Record {x+1} Entry Successful") #print if the entry was successful

        file.write("{:<20} {:<20} {:<20} {:<20} {:<20}\n".format((x+1),name,age,id,service)) #write the values to the file with the proper formatting of 20 spaces each


main() #runs the python file