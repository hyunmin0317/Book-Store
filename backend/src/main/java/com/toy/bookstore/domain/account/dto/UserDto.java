package com.toy.bookstore.domain.account.dto;

import com.toy.bookstore.domain.account.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;


public class UserDto {
    @Data
    @Builder
    @ApiModel(value = "UserDtoResponse")
    public static class Response {
        private String username;
        private String token;

        public static Response of(String username, String token) {
            return Response.builder()
                    .username(username)
                    .token(token)
                    .build();
        }
    }

    @Data
    @Builder
    @ApiModel(value = "UserDtoRequest")
    public static class Request {
        private String username;
        private String password;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .build();
        }
    }
}
