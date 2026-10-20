package com.vladko.tasktrackerbackend.database.repository;

import com.vladko.tasktrackerbackend.database.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Проверка сохранений")
    void save(){
        User user = new User("vladislavkov390@gmail.com", "1234");
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
        System.out.println(savedUser);

        // Проверяем, что БД сгенерировала ID (если у вас стоит @GeneratedValue)
        assertThat(savedUser.getId()).isNotNull();

        // Проверяем, что поля сохранились ровно так, как мы передавали
        assertThat(savedUser.getEmail()).isEqualTo("vladislavkov390@gmail.com");
        assertThat(savedUser.getPassword()).isEqualTo("1234");
    }

    @Test
    void delete(){
        User user = new User("vladislavkov390@gmail.com", "1234");
        User savedUser = userRepository.save(user);
        userRepository.delete(savedUser);
        assertThat(userRepository.findByEmail("vladislavkov390@gmail.com").isPresent());
    }

}
