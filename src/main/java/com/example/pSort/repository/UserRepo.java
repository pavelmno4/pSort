package com.example.pSort.repository;

import com.example.pSort.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {      //Связь между классом пользователя
                                                                   //и базой данных
    User findByUsername(String username);
}
