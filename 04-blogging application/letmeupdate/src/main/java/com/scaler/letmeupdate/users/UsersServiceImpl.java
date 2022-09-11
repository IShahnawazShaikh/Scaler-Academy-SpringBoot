package com.scaler.letmeupdate.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    private ModelMapper modelMapper;

    private UserJwtService jwtService;

    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, UserJwtService jwtService, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UsersDTO.LoginUserResponse signup(UsersDTO.CreateUserRequest userRequest){
        // TODO: Check valid and unique username/email
        UserEntity userEntity=modelMapper.map(userRequest,UserEntity.class);
        userEntity.setCreatedAt(new Date());
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        var savedEntity=usersRepository.save(userEntity);
        UsersDTO.LoginUserResponse loginUserResponse=modelMapper.map(savedEntity, UsersDTO.LoginUserResponse.class);
        loginUserResponse.setToken(jwtService.createJwtTokenFromUsername(userRequest.getUsername()));
        return loginUserResponse;
    }

    @Override
    public UsersDTO.LoginUserResponse login(UsersDTO.LoginUserRequest loginRequest) {

        var responseEntity = usersRepository.findByUsername(loginRequest.getUsername()).orElseThrow(
                ()->new UserNotFoundException(loginRequest.getUsername())
        );

        if(passwordEncoder.matches(loginRequest.getPassword(),responseEntity.getPassword())){
            UsersDTO.LoginUserResponse loginUserResponse=modelMapper.map(responseEntity, UsersDTO.LoginUserResponse.class);
            loginUserResponse.setToken(jwtService.createJwtTokenFromUsername(loginRequest.getUsername()));
            return loginUserResponse;
        }
        else{
           throw new UserAuthenticationException();
        }

    }

    @Override
    public UsersDTO.GetUserResponse findByUsername(String username) {
       var userEntity= usersRepository.findByUsername(username).orElseThrow(
            ()-> new UserNotFoundException(username)
       );
       UsersDTO.GetUserResponse userResponse=modelMapper.map(userEntity,UsersDTO.GetUserResponse.class);
       return userResponse;
    }


    public UserEntity findUserEntityByUsername(String username) {
        var userEntity= usersRepository.findByUsername(username).orElseThrow(
                ()-> new UserNotFoundException(username)
        );
       return userEntity;
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
