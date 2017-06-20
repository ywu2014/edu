package com.jiangnan.edu.service.impl;

import com.jiangnan.edu.entity.User;
import com.jiangnan.edu.repository.UserRepository;
import com.jiangnan.edu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴叶俊
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public void create(User pmsUser) {
        userRepository.save(pmsUser);
    }

    @Override
    public User getById(Long userId) {
        return null;
    }

    @Override
    public User findUserByUserNo(String userNo) {
        return null;
    }

    @Override
    public void deleteUserById(long userId) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void updateUserPwd(Long userId, String newPwd, boolean isTrue) {

    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
