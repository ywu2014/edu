package com.jiangnan.edu.repository;

import com.jiangnan.edu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 吴叶俊
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
