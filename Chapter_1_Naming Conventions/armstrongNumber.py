
def getArmstrongNumber(number):
    # Initializing Sum and Number of Digits
    sum = 0
    numberOfDigits = 0

    # Calculating Number of individual digits
    tempNumber = number
    while tempNumber > 0:
        numberOfDigits = numberOfDigits + 1
        tempNumber = tempNumber // 10

    # Finding Armstrong Number
    tempNumber = number
    for n in range(1, tempNumber + 1):
        digit = tempNumber % 10
        sum = sum + (digit ** numberOfDigits)
        tempNumber //= 10
    return sum


# End of Function

# User Input
userInput = int(input("\nPlease Enter the Number to Check for Armstrong: "))

if (userInput == getArmstrongNumber(userInput)):
    print("\n %d is Armstrong Number.\n" % userInput)
else:
    print("\n %d is Not a Armstrong Number.\n" % userInput)