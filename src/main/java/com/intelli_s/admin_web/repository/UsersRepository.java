package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.UserVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.User;

public interface UsersRepository extends Repository<UserVO, Integer> {

    @Query("SELECT user FROM UserVO user left join fetch user.auths WHERE user.userId = :userId")
    UserVO getByUserId(String userId);

    void save(UserVO userVO);
}
