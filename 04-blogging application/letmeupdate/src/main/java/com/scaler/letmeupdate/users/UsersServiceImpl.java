package com.scaler.letmeupdate.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    UsersServiceImpl(@Autowired UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    @Override
    public UsersDTO.UserResponse signup(UsersDTO.CreateUserRequest userRequest){
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setBio(userRequest.getBio());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());

        var savedEntity=usersRepository.save(userEntity);

        UsersDTO.UserResponse userResponse=new UsersDTO.UserResponse();
        userResponse.setId(savedEntity.getId());
        userResponse.setUsername(savedEntity.getUsername());
        return userResponse;
    }

    @Override
    public UsersDTO.UserResponse login(UsersDTO.LoginRequest loginRequest) {

        var responseEntity = usersRepository.findByUsername(loginRequest.getUsername()).orElseThrow(
                ()->new UserNotFoundException(loginRequest.getUsername())
        );
        // TODO: Mathc Password By Hashing
        if(responseEntity.getPassword().equals(loginRequest.getPassword())){
            UsersDTO.UserResponse userResponse=new UsersDTO.UserResponse();
            userResponse.setId(responseEntity.getId());
            userResponse.setFirstName(responseEntity.getFirstName());
            return userResponse;
        }
        else{
           throw new UserAuthenticationException();
        }

    }



    // ********* Customized Exception ***********************
    static class UserNotFoundException extends RuntimeException{
        UserNotFoundException(String username){
            super("No Such User found with Username "+username);
        }
    }
    static class UserAuthenticationException extends SecurityException{
        UserAuthenticationException(){
            super("User Authentication failed");
        }
    }
}
