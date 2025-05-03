package com.atm.atm_simulator.repository;

import com.atm.atm_simulator.model.Card;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CardRepository {
    private final Map<String, Card> cards = new HashMap<>();

    public Card getCardByNumber(String cardNumber) {
        return cards.get(cardNumber);
    }

    public void createCard(Card card) {
        cards.put(card.getCardNumber(), card);
    }
}
