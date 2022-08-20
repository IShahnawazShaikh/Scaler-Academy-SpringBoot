package com.scaler.letmeupdate.users;

import com.scaler.letmeupdate.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @NonNull
    @Column(name="username",nullable = false,unique = true)
    private String username;

    @NonNull
    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @NonNull
    @Column(name="email", nullable = false,unique = true)
    private String email;
    private String avatar;
    private String bio;

}
