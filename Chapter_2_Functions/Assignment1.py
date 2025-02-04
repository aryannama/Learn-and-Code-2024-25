def isValidGuess(s):
    if s.isdigit() and 1 <= int(s) <= 100:
        return True
    else:
        return False

def main():
    numberToGuess = random.randint(1, 100)
    isCorrectGuess = False
    guess = input("Guess a number between 1 and 100: ")
    numberOfGuesses = 0

    while not isCorrectGuess:
        if not isValidGuess(guess):
            guess = input("I wont count this one Please enter a number between 1 and 100")
            continue
        else:
            numberOfGuesses += 1
            guess = int(guess)

        if guess < numberToGuess:
            guess = input("Too Low. Guess again")
        elif guess > numberToGuess:
            guess = input("Too High. Guess again")
        else:
            print("You guessed it in", numberOfGuesses, "guesses!")
            isCorrectGuess = True

main()