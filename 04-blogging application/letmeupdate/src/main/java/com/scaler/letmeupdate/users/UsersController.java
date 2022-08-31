package com.scaler.letmeupdate.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersServiceImpl usersServiceImpl;
    UsersController(@Autowired UsersServiceImpl usersServiceImpl){
        this.usersServiceImpl=usersServiceImpl;
    }
    @PostMapping("/signup")
    ResponseEntity<UsersDTO.UserResponse> signup(@RequestBody UsersDTO.CreateUserRequest userRequest){
        var response=usersServiceImpl.signup(userRequest);
        return ResponseEntity.created(
                URI.create("/users/"+response.getId())
        ).body(response);
    }

   @PostMapping("/login")
   ResponseEntity <UsersDTO.UserResponse> login(@RequestBody UsersDTO.LoginRequest loginRequest){
       var response=usersServiceImpl.login(loginRequest);
       return ResponseEntity.ok(response);
   }


}
