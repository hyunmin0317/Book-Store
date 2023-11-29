package com.toy.bookstore.domain.account.controller;

import com.toy.bookstore.domain.account.dto.UserDto;
import com.toy.bookstore.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto.Response> signup(@RequestBody UserDto.Request request) {
        UserDto.Response response = accountService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<UserDto.Response> signIn(@RequestBody UserDto.Request request) {
        UserDto.Response response = accountService.signin(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
