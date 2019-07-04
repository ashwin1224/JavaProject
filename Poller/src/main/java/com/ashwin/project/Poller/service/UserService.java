package com.ashwin.project.Poller.service;

import com.ashwin.project.Poller.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}