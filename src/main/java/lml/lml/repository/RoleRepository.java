package lml.lml.repository;//package com.example.lml.repository;
//
//
//import com.example.lml.demolml.domain.PermissionAssignment;
//import com.example.lml.demolml.domain.Role;
//import com.example.lml.demolml.domain.RoleAssignment;
//import com.example.lml.demolml.domain.RoleRoot;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface RoleRepository {
//    List<Role> findAllOfRole();
//
//    List<Role> findOneOfRoleByRoleId(String id);
//
//    List<RoleRoot> findAllOfPA();
//
//    List<RoleAssignment> findAllOfRA();
//
//    List<RoleRoot> findOneOfRAByUserId(String id);
//
//    List<RoleRoot> findOneOfPAByPermissionId(String id);
//
//    boolean deleteOfPAByRoleId(String id);
//
//    boolean deleteOfRAByRoleId(String id);
//
//    boolean deleteOfRGAByRoleId(String id);
//
//    boolean deleteOfRoleByRoleId(String id);
//
//    boolean resetSuperId(String id);
//
//    boolean addRole(Role role);
//
//    boolean updateRole(@Param("role") Role role, @Param("ID") String ID);
//
//    boolean updateRoleState(@Param("ID") String ID, @Param("state") int state);
//
//    boolean dispatch(@Param("id") String id, @Param("userId") String userId, @Param("roleId") String roleId);
//
//    boolean deletePermissionAll(String roleId);
//
//    boolean deletePermissionOne(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
//
//    //内连接查询，一次就用userId查询Role表
//    List<Role> liuminglang(String id);
//}
