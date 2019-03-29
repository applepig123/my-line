package com.yh.line.chat.service;

import com.yh.line.common.pojo.User;
import com.yh.line.chat.data.repository.UserDao;
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
