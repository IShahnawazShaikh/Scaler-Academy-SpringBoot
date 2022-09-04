package com.scaler.letmeupdate.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    private ModelMapper modelMapper;

    private UserJwtService jwtService;

    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, UserJwtService jwtService) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    @Override
    public UsersDTO.LoginUserResponse signup(UsersDTO.CreateUserRequest userRequest){
        // TODO: Check valid and unique username/email
        UserEntity userEntity=modelMapper.map(userRequest,UserEntity.class);
        var savedEntity=usersRepository.save(userEntity);
        UsersDTO.LoginUserResponse loginUserResponse=modelMapper.map(savedEntity, UsersDTO.LoginUserResponse.class);
        loginUserResponse.setToken(jwtService.createJwtToken(userRequest.getUsername()));
        return loginUserResponse;
    }

    @Override
    public UsersDTO.LoginUserResponse login(UsersDTO.LoginUserRequest loginRequest) {

        var responseEntity = usersRepository.findByUsername(loginRequest.getUsername()).orElseThrow(
                ()->new UserNotFoundException(loginRequest.getUsername())
        );
        // TODO: Mathc Password By Hashing
        if(responseEntity.getPassword().equals(loginRequest.getPassword())){
            UsersDTO.LoginUserResponse loginUserResponse=modelMapper.map(responseEntity, UsersDTO.LoginUserResponse.class);
            loginUserResponse.setToken(jwtService.createJwtToken(loginRequest.getUsername()));
            return loginUserResponse;
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
