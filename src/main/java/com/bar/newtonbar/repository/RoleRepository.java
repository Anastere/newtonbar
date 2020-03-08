package com.bar.newtonbar.repository;

import com.bar.newtonbar.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findRoleByName(String name);
    Role findRoleById(Long id);

}
