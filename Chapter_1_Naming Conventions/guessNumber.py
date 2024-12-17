def isValidNumber(guess):
    if guess.isdigit() and 1<= int(guess) <=100:
        return True
    else:
        return False

def main():
    number=random.randint(1,100)
    isCorrect=False
    userGuess=input("Guess a number between 1 and 100:")
    numberOfGuess=0
    while not isCorrect:
        if not isValidNumber(userGuess):
            userGuess=input("I wont count this one Please enter a number between 1 to 100")
            continue
        else:
            numberOfGuess+=1
            userGuess=int(userGuess)

        if userGuess<number:
            userGuess=input("Too low. Guess again")
        elif userGuess>number:
            userGuess=input("Too High. Guess again")
        else:
            print("You guessed it in",numberOfGuess,"guesses!")
            isCorrect=True


main()