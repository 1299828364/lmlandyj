package lml.lml.repository;//package com.example.lml.repository;
//
//import com.example.lml.demolml.domain.Permission;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PermissionRepository {
//    public List<Permission> findAll();
//
//    List<Permission> findOneById(String id);
//
//    List<Permission> findAllByRoleId(String roleId);
//
//    List<Permission> findAllByUserId(String userId);
//
//    boolean deleteById(String id);
//    boolean deletePAByPermissionId(String id);
//    boolean deleteFAByPermissionId(String id);
//
//    boolean addPermission(Permission permission);
//
//    /**
//     *
//     * @param permissionId
//     * @param featureId
//     * @param id
//     * @param remark
//     * @return
//     */
//    boolean addPowerOfPermission(@Param("permissionId") String permissionId,
//                                 @Param("featureId") String featureId,
//                                 @Param("id") String id,
//                                 @Param("remark") String remark);
//
//    boolean updatePermission(@Param("permission") Permission permission);
//}
