package com.yh.line.chat.data.service;

import com.yh.line.chat.data.repository.UserDao;
import com.yh.line.chat.data.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by yanghua on 2019/3/26.
 */
@Service
public class UserService {

    private UserDao userDao;

    public User getUserById(Long id) {
        return new User();
    }
}
