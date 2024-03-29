package com.scaler.letmeupdate.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersServiceImpl usersServiceImpl;
    UsersController(@Autowired UsersServiceImpl usersServiceImpl){
        this.usersServiceImpl=usersServiceImpl;
    }
    @PostMapping("/signup")
    ResponseEntity<UsersDTO.LoginUserResponse> signup(@RequestBody UsersDTO.CreateUserRequest userRequest){
        var response=usersServiceImpl.signup(userRequest);
        return ResponseEntity.created(
                URI.create("/users/"+response.getId())
        ).body(response);
    }

   @PostMapping("/login")
   ResponseEntity <UsersDTO.LoginUserResponse> login(@RequestBody UsersDTO.LoginUserRequest loginRequest){
       var response=usersServiceImpl.login(loginRequest);
       return ResponseEntity.ok(response);
   }

   @GetMapping("/@{username}")
   HttpStatus getUserByUsername(@PathVariable("username") String username,
                                @AuthenticationPrincipal UserEntity authenticatedUser){
       var user=usersServiceImpl.findByUsername(username);
        return ResponseEntity.notFound();
       //return ResponseEntity.ok(user);
   }

   @GetMapping("/all")
    ResponseEntity<List<UsersDTO.GetUserResponse>> getAllUsers(){
       var response=usersServiceImpl.getAllUsers();
        return ResponseEntity.ok(response);
   }


}
