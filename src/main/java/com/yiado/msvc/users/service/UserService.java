package com.yiado.msvc.users.service;

import com.yiado.msvc.users.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllList();
    Optional<User> findById(Long id);
    List<User> findAllById(Iterable<Long> ids);
    User save(User user);
    void deleteById(Long id);
}
