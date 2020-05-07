package com.szmolke.coderslab.submissions.service;

import com.szmolke.coderslab.submissions.dao.UserDao;
import com.szmolke.coderslab.submissions.model.User;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void createUser() {
        User user = userDao.create(new User("Name", "pass", "email"));
        System.out.println(user);
    }
}
