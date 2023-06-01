package com.yiado.msvc.users.repository;

import com.yiado.msvc.users.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
}
