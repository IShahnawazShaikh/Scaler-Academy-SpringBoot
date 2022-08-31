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
    public static class LoginRequest{
        private String username;
        private String password;
    }
    @Data
    public static class UserResponse{
        private Integer id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String bio;
        // TODO: Token will generate
        private String token;
    }

}
