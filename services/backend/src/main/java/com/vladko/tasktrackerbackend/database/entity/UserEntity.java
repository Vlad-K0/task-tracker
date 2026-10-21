package com.vladko.tasktrackerbackend.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;
}
