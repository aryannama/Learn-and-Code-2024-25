import random

def getRandomSide(totalSides):
    side=random.randint(1, totalSides)
    return side


def main():
    totalSides=6
    isRolling=True
    while isRolling:
        userInput=input("Ready to roll? Enter Q to Quit")
        if userInput.lower() !="q":
            rolledSide=getRandomSide(totalSides)
            print("You have rolled a",rolledSide)
        else:
            isRolling=False

main()