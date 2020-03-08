package com.bar.newtonbar.repository;

import com.bar.newtonbar.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByNameAndLastname(String name, String lastname);
    User findByName(String name);

}
