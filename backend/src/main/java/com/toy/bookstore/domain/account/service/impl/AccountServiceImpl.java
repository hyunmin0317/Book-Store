package com.toy.bookstore.domain.account.service.impl;

import com.toy.bookstore.domain.account.dto.UserDto;
import com.toy.bookstore.domain.account.entity.User;
import com.toy.bookstore.domain.account.repository.UserRepository;
import com.toy.bookstore.domain.account.service.AccountService;
import com.toy.bookstore.global.config.security.JwtTokenProvider;
import com.toy.bookstore.global.error.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto.Response signup(UserDto.Request request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new RestException(HttpStatus.CONFLICT);
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = request.toEntity();
        User savedUser = userRepository.save(user);
        String token  = jwtTokenProvider.createToken(savedUser.getUsername());
        return UserDto.Response.of(savedUser.getUsername(), token);
    }

    @Override
    public UserDto.Response signin(UserDto.Request request) {
        return null;
    }
}
