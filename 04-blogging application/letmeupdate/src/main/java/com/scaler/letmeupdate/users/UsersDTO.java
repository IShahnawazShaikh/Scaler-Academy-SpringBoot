package com.scaler.letmeupdate.users;

import lombok.Data;

public class UsersDTO {

    @Data
    public static class CreateUserRequest{
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String bio;

    }

    @Data
    public static class LoginUserRequest {
        private String username;
        private String password;
    }
    @Data
    public static class LoginUserResponse {
        private Integer id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String bio;
        private String token;
    }

    @Data
    public static class GetUserResponse{
        private Integer id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String bio;
    }
}
