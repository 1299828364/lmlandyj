package lml.lml.service.impl;//package com.example.lml.service.impl;
//
//import com.example.lml.demolml.domain.Permission;
//import com.example.lml.demolml.domain.Result;
//import com.example.lml.demolml.repository.FeatureRepository;
//import com.example.lml.demolml.repository.PermissionRepository;
//import com.example.lml.demolml.repository.RoleRepository;
//import com.example.lml.demolml.repository.UserRepository;
//import com.example.lml.demolml.service.PermissionService;
//import com.example.lml.demolml.utils.EntityIDFactory;
//import com.example.lml.demolml.utils.ResultUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PermissionServiceImpl implements PermissionService {
//
//    @Autowired
//    PermissionRepository permissionRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    FeatureRepository featureRepository;
//
//
//    /**
//     * 获取权限详情
//     * @return
//     */
//    @Override
//    public Result<Permission> findAll() {
//        return ResultUtil.success(permissionRepository.findAll());
//
//    }
//
//    /**
//     * 通过权限id获取权限详情
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<Permission> findOneById(String id) {
//        List<Permission> pList=permissionRepository.findOneById(id);
//        if (pList.size()==0){
//            return ResultUtil.error(500,"权限id不存在",0);
//        }
//        return ResultUtil.success(pList);
//    }
//
//    /**
//     * 根据角色id获取权限详情
//     * @param roleId
//     * @return
//     */
//    @Override
//    public Result<Permission> findAllByRoleId(String roleId) {
//        List<Permission> list=permissionRepository.findAllByRoleId(roleId);
//        ArrayList<String> existId=new ArrayList();
//        for(Permission permission:list){
//            int idListSize=0;
//            int idListMaxSize=existId.size();
//            for (String id :existId){
//                idListSize++;
//                if(permission.getId().equals(id)){
//                    list.remove(permission);
//                    break;
//                }
//            }
//            if(idListSize==idListMaxSize){
//                existId.add(permission.getId());
//            }
//        }
//
//        return ResultUtil.success(list,"根据角色id获取详情");
//    }
//
//    @Override
//    public Result<Permission> findAllByUserId(String userId) {
//        if (userRepository.findOneById(userId).size()==0){
//            return ResultUtil.error(500,"用户ID不存在",0);
//        }
//        return ResultUtil.success(permissionRepository.findAllByUserId(userId),"根据用户id获取详情");
//    }
//
//
//    /**
//     * 删除权限
//     * @param id
//     * @return
//     */
//    @Override
//    public Result deleteById(String id) {
//        if (permissionRepository.findOneById(id).size()==0){
//            return ResultUtil.error(500,"权限Id不存在",0);
//        }
//        permissionRepository.deleteFAByPermissionId(id);
//        permissionRepository.deletePAByPermissionId(id);
//        permissionRepository.deleteById(id);
//        return ResultUtil.success(1,"根据权限Id删除");
//    }
//
//    /**
//     * 添加权限
//     * @param powerId
//     * @param permission
//     * @return
//     */
//    @Override
//    public Result addPermission (String powerId,Permission permission) {
//        if(featureRepository.findOne(powerId).size()==0){
//            return ResultUtil.error(500,"功能id不存在",0);
//        }
//
//        try {
//            permissionRepository.addPermission(permission);
//            permissionRepository.addPowerOfPermission(permission.getId(),powerId,EntityIDFactory.createID(),"");
//            return ResultUtil.success(1,"权限添加");
//        }catch (Exception e){
//            return ResultUtil.error(503,"服务器暂停服务",0);
//        }
//    }
//
//    /**
//     * 权限更新
//     * @param powerId
//     * @param permission
//     * @return
//     */
//    @Override
//    public Result updatePermission(String powerId,Permission permission) {
//
//        if (permissionRepository.findOneById(permission.getId()).size()==0){
//            return ResultUtil.error(500,"权限id不存在",0);
//        }
//        if(featureRepository.findOne(powerId).size()==0){
//            return ResultUtil.error(500,"功能id不存在",0);
//        }
//
//
//
//        permissionRepository.updatePermission(permission);
//        return ResultUtil.success(1,"修改权限");
//    }
//
//
//}