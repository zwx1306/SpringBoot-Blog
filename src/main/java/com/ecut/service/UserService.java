package com.ecut.service;

import com.ecut.domain.User;

public interface UserService {
    User checkUser(String username, String password);
}
