package com.toy.bookstore.domain.account.dto;

import com.toy.bookstore.domain.account.entity.User;
import com.toy.bookstore.global.common.CommonResponse;
import lombok.Builder;
import lombok.Data;

public class UserDto {
    @Data
    @Builder
    public static class Response {
        private boolean success;
        private int code;
        private String msg;
        private String token;

        public static Response of(boolean success, String token) {
            CommonResponse response = success ? CommonResponse.SUCCESS : CommonResponse.FAIL;
            return Response.builder()
                    .success(success)
                    .token(token)
                    .code(response.getCode())
                    .msg(response.getMsg())
                    .build();
        }
    }

    @Data
    @Builder
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
