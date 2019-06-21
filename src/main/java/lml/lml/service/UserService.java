package lml.lml.service;

import lml.lml.domain.Result;
import lml.lml.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    Result findAll();

    Result findOneByNo(String userNo);

    Result updateUser(User user);

    Result deleteByUserNo(String userNo);

    Result addRole(User user);
}
