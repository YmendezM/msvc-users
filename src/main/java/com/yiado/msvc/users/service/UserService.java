package com.yiado.msvc.users.service;

import com.yiado.msvc.users.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllList();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
