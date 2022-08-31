package com.scaler.letmeupdate.users;

public interface UsersService {
  public UsersDTO.UserResponse signup(UsersDTO.CreateUserRequest userRequest);
  public UsersDTO.UserResponse login(UsersDTO.LoginRequest loginRequest);
}
