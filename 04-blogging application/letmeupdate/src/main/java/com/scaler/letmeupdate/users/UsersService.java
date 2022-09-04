package com.scaler.letmeupdate.users;

public interface UsersService {
  public UsersDTO.LoginUserResponse signup(UsersDTO.CreateUserRequest userRequest);
  public UsersDTO.LoginUserResponse login(UsersDTO.LoginUserRequest loginRequest);
}
