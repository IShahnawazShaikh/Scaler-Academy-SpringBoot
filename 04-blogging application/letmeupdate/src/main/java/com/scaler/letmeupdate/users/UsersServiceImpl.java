package com.scaler.letmeupdate.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    private ModelMapper modelMapper;

    UsersServiceImpl(@Autowired UsersRepository usersRepository, ModelMapper modelMapper){
        this.usersRepository=usersRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public UsersDTO.UserResponse signup(UsersDTO.CreateUserRequest userRequest){

        UserEntity userEntity=modelMapper.map(userRequest,UserEntity.class);
        var savedEntity=usersRepository.save(userEntity);
        UsersDTO.UserResponse userResponse=modelMapper.map(savedEntity,UsersDTO.UserResponse.class);

        return userResponse;
    }

    @Override
    public UsersDTO.UserResponse login(UsersDTO.LoginRequest loginRequest) {

        var responseEntity = usersRepository.findByUsername(loginRequest.getUsername()).orElseThrow(
                ()->new UserNotFoundException(loginRequest.getUsername())
        );
        // TODO: Mathc Password By Hashing
        if(responseEntity.getPassword().equals(loginRequest.getPassword())){
            UsersDTO.UserResponse userResponse=modelMapper.map(responseEntity,UsersDTO.UserResponse.class);
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
