package com.atm.atm_simulator.service;

import com.atm.atm_simulator.exceptions.CardBlockedException;
import com.atm.atm_simulator.exceptions.CardNotFoundException;
import com.atm.atm_simulator.exceptions.InvalidPinException;
import com.atm.atm_simulator.model.Account;
import com.atm.atm_simulator.model.Card;
import com.atm.atm_simulator.repository.CardRepository;
import com.atm.atm_simulator.util.CardUtil;
import org.springframework.stereotype.Service;

import static com.atm.atm_simulator.constants.ATM.INVALID_PIN_ATTEMPTS_ALLOWED;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard(Account account) {
        Card card = new Card();
        card.setCardNumber(CardUtil.generateCardNumber());
        card.setPin(CardUtil.generatePin());
        card.setAccountNumber(account.getAccountNumber());
        card.setBlocked(false);
        card.setInvalidPinAttempts(0);

        cardRepository.createCard(card);
        return card;
    }

    public Card getCardDetails(String cardNumber) {
        Card card = cardRepository.getCardByNumber(cardNumber);

        if (card == null) {
            throw new CardNotFoundException(cardNumber);
        }

        return card;
    }

    public Card validateCardAndPin(String cardNumber, int pin) {
        Card card = getCardDetails(cardNumber);

        if (card.isBlocked()) {
            throw new CardBlockedException();
        }

        validatePin(card, pin);
        card.setInvalidPinAttempts(0);

        return card;
    }

    public void validatePin(Card card, int pin) {
        if (card.getPin() != pin) {
            int attempts = card.getInvalidPinAttempts() + 1;
            card.setInvalidPinAttempts(attempts);
            if (attempts >= INVALID_PIN_ATTEMPTS_ALLOWED) {
                card.setBlocked(true);
                throw new CardBlockedException();
            }
            throw new InvalidPinException(attempts);
        }
    }
}
