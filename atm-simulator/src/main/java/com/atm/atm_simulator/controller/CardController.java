package com.atm.atm_simulator.controller;

import com.atm.atm_simulator.model.Card;
import com.atm.atm_simulator.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/details")
    public ResponseEntity<Card> getCardDetails(@RequestParam String cardNumber) {
        Card card = cardService.getCardDetails(cardNumber);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }
}
