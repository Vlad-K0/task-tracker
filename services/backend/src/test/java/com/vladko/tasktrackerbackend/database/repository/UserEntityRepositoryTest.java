package com.vladko.tasktrackerbackend.database.repository;

import com.vladko.tasktrackerbackend.database.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserEntityRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Проверка сохранений")
    void save(){
        UserEntity userEntity = new UserEntity("vladislavkov390@gmail.com", "1234");
        UserEntity savedUserEntity = userRepository.save(userEntity);
        assertThat(savedUserEntity).isNotNull();
        // Проверяем, что БД сгенерировала ID (если у вас стоит @GeneratedValue)
        assertThat(savedUserEntity.getId()).isNotNull();

        // Проверяем, что поля сохранились ровно так, как мы передавали
        assertThat(savedUserEntity.getEmail()).isEqualTo("vladislavkov390@gmail.com");
        assertThat(savedUserEntity.getPassword()).isEqualTo("1234");
    }

    @Test
    void delete(){
        UserEntity userEntity = new UserEntity("vladislavkov390@gmail.com", "1234");
        UserEntity savedUserEntity = userRepository.save(userEntity);
        userRepository.delete(savedUserEntity);
        assertThat(userRepository.findByEmail("vladislavkov390@gmail.com").isPresent()).isFalse();
    }

}
