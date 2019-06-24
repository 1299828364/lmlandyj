package lml.lml.repository;


import lml.lml.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<User> findAll();

    User findOneByNo(@Param("userNo")String userNo);

    boolean editUser(User user);

    boolean deleteByUserNo(@Param("userNo")String userNo);

    User findOneByAccount(@Param("userAccount")String account);
}
