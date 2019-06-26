package lml.lml.service;

import lml.lml.domain.Course;
import lml.lml.domain.Result;
import lml.lml.domain.Role;

import java.util.Date;

public interface RoleService {

    /**
     * 查询所有的文章
     *
     * @return
     */
    Result findAll();

    /**
     * 新增角色
     * @param role
     * @return
     */
    Result addRole(Role role);



    /**
     *通过角色对象删除
     * @param role
     * @return
     */
    Result deleteRole(Role role);

    /**
     *通过角色No删除
     * @param roleNo
     * @return
     */
    Result deleteRole(String roleNo);


    /**
     * 更新角色
     * @param role
     * @return
     */
    Result updateRole(Role role);


    Result findByPage(String page);
}
