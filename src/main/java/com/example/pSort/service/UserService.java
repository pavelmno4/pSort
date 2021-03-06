package com.example.pSort.service;

import com.example.pSort.domain.Role;
import com.example.pSort.domain.User;
import com.example.pSort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //Поиск пользователя
                                                                                              //по имени
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {                                     //Добавить пользователя
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }               //Поиск всех пользователей

    public void saveUser(User user, String username, Map<String, String> form, String password) {  //Сохранить пользователя
                                                                                  //с установленным именем и ролями
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        user.setPassword(passwordEncoder.encode(password));

        userRepo.save(user);
    }

    public void updateProfile(User user, String password) {
        if(!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        userRepo.save(user);
    }
}
