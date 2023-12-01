file = open('employeedb.txt', 'w')

records = int(input("Number of Records to enter "))

for x in range(records):
    input("Enter Name ")
    input("Enter Age ")
    input("Enter EmployeedID ")
    input("Enter Years of Service ")


    print(f"Record {x+1} Entry Successful")


