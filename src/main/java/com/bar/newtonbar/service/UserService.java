package com.bar.newtonbar.service;

import com.bar.newtonbar.repository.RoleRepository;
import com.bar.newtonbar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
}
