package lml.lml.service.impl;


import lml.lml.domain.Result;
import lml.lml.domain.Role;
import lml.lml.repository.RoleRepository;
import lml.lml.service.RoleService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Result findAll() {
        return ResultUtil.success(roleRepository.findAll());
    }

    @Override
    public Result addRole(Role role) {
        return ResultUtil.success(roleRepository.editRole(role));
    }

    @Override
    public Result deleteRole(Role role) {
        return ResultUtil.success(roleRepository.deleteByRoleNo(role.getRoleNo()));
    }

    @Override
    public Result deleteRole(String roleNo) {
        return ResultUtil.success(roleRepository.deleteByRoleNo(roleNo));
    }

    @Override
    public Result updateRole(Role role) {
        return null;
    }

    @Override
    public Result findByPage(String page) {
        int tempPage=Integer.valueOf(page);
        if(tempPage==0){
            tempPage=tempPage;
        }else {
            tempPage=tempPage*10-1;
        }
        return ResultUtil.success(roleRepository.findByPage(tempPage));
    }
}
