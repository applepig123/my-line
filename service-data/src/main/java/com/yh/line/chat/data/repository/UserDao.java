package com.yh.line.chat.data.repository;

import com.yh.line.repo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by yanghua on 2019/3/26.
 */
@Repository
public interface UserDao {
    User selectById(@Param("id") Long id);
}
