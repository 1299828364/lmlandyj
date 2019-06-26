package lml.lml.service.impl;

import lml.lml.domain.Result;
import lml.lml.domain.User;
import lml.lml.repository.UserRepository;
import lml.lml.service.UserService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Result findAll() {
        return ResultUtil.success(userRepository.findAll());
    }

    @Override
    public Result findOneByNo(String userNo) {
        return ResultUtil.success(userRepository.findOneByNo(userNo));
    }

    @Override
    public Result updateUser(User user) {
        return ResultUtil.success(userRepository.editUser(user));
    }

    @Override
    public Result deleteByUserNo(String userNo) {
        return ResultUtil.success(userRepository.deleteByUserNo(userNo));
    }

    @Override
    public Result addRole(User user) {
        return ResultUtil.success(userRepository.editUser(user));
    }

    @Override
    public boolean loginCheck(User user) {
        User tempUser=userRepository.findOneByAccount(user.getUserAccount());
        if (tempUser.getPassword().equals(user.getPassword())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Result findByPage(String page) {
        int tempPage=Integer.valueOf(page);
        if(tempPage==0){
            tempPage=tempPage;
        }else {
            tempPage=tempPage*10-1;
        }
        return ResultUtil.success(userRepository.findByPage(tempPage));
    }
}
