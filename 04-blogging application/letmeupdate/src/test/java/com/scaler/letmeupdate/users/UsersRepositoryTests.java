package com.scaler.letmeupdate.users;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UsersRepositoryTests {
    @Autowired
    UsersRepository usersRepository;

    @Test
    @Order(1)
    void can_find_user_by_username(){
        usersRepository.save(
                UserEntity.builder()
                        .username("ishahnawazshaikh")
                        .email("shaz@gmail.com")
                        .firstName("Shahnawaz")
                        .build()

        );
       var user=usersRepository.findUserByUsername("ishahnawazshaikh")
                       .orElseThrow(()->new RuntimeException("User Not Found"));

       assertEquals(user.getUsername(),"ishahnawazshaikh");

    }

}
