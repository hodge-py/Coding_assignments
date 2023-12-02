file = open('employeedb.txt', 'w')

records = int(input("Number of Records to enter "))

for x in range(records):
    name = input("Enter Name ")
    for x in name:
        if x not in range(48,58):
            pass
    age = input("Enter Age ")
    id = input("Enter EmployeedID ")
    service = input("Enter Years of Service ")


    print(f"Record {x+1} Entry Successful")


