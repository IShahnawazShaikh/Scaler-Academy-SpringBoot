package com.scaler.letmeupdate.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserByUsername(String ishahnawazshaikh);
}