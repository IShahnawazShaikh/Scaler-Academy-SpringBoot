package com.scaler.letmeupdate.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEntityRepository extends JpaRepository<UserEntity, Integer> {
}