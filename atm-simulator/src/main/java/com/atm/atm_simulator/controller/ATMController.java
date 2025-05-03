package com.atm.atm_simulator.controller;

import com.atm.atm_simulator.dto.WithdrawRequest;
import com.atm.atm_simulator.dto.WithdrawResponse;
import com.atm.atm_simulator.service.ATMService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atm")
public class ATMController {

    private final ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<WithdrawResponse> withdraw(@RequestBody WithdrawRequest withdrawRequest) {
        WithdrawResponse withdrawResponse = atmService.processWithdrawal(withdrawRequest.getCardNumber(), withdrawRequest.getPin(), withdrawRequest.getAmount());
        return new ResponseEntity<>(withdrawResponse, HttpStatus.OK);
    }
}
