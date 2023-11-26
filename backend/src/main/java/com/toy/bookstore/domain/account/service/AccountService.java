package com.toy.bookstore.domain.account.service;

import com.toy.bookstore.domain.account.dto.UserDto;

public interface AccountService {
    UserDto.Response signup(UserDto.Request request);
    UserDto.Response signin(UserDto.Request request);
}
