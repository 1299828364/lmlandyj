package lml.lml.service.impl;//package com.example.lml.service.impl;
//
//
//import com.example.lml.demolml.repository.PermissionRepository;
//import com.example.lml.demolml.domain.*;
//import com.example.lml.demolml.repository.RoleRepository;
//import com.example.lml.demolml.repository.UserRepository;
//import com.example.lml.demolml.service.RoleService;
//import com.example.lml.demolml.utils.ResultUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.example.lml.demolml.utils.EntityIDFactory.createID;
//
//@Service
//public class RoleServiceImpl implements RoleService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//
//    @Autowired
//    private PermissionRepository permissionRepository;
//
//
//
//
//    @Override
//    public Map findAllOfRole() {
////        List<Role> roleList=roleRepository.findAllOfRole();
//        return getRoleTree(roleRepository.findAllOfRole());
//    }
//
//    @Override
//    public Role findOneByRoleId(String id) {
//        return roleRepository.findOneOfRoleByRoleId(id).get(0);
//    }
//
//    //
//    @Override
//    public Map<String, Object> findOneOfRoleByPermissionId(String id) {
//        List<RoleRoot> listTemp=roleRepository.findOneOfPAByPermissionId(id);
//        return getRoleTree(getRoleList(listTemp));
//    }
//
//
//
//    @Override
//    public Map<String, Object> findOneOfRoleByUserId(String id) {
//        List<RoleRoot> listTemp=roleRepository.findOneOfRAByUserId(id);
//        return getRoleTree( getRoleList(listTemp));
//    }
//
////    这是查一次的情况
////    @Override
////    public List<Role> findOneOfRoleByUserId(String id) {
////        return roleRepository.liuminglang(id);
////    }
//
//    @Override
//    public boolean deleteOfRoleByRoleId(String id) {
//        roleRepository.resetSuperId(id);
//        roleRepository.deleteOfPAByRoleId(id);
//        roleRepository.deleteOfRAByRoleId(id);
//        roleRepository.deleteOfRGAByRoleId(id);
//        return roleRepository.deleteOfRoleByRoleId(id);
//    }
//
//    @Override
//    public boolean addRole(Role role){
//        return roleRepository.addRole(role);
//    }
//
//    @Override
//    public boolean updateRole(Role role, String ID) {
//        return roleRepository.updateRole(role,ID);
//    }
//
//    @Override
//    public Result updateRoleState(String IDs, String states) {
//        ArrayList idList=fenGeByDouHao(IDs);
//        try {
//            for (int i=0;i<idList.size();i++){
//                roleRepository.updateRoleState(idList.get(i).toString(),Integer.valueOf(states));
//            }
//        }catch (Exception e){
//            return ResultUtil.error(500,"参数异常或缺少","0");
//        }
//        return ResultUtil.success(1,"批量启用停用角色");
//    }
//
//    @Override
//    public Result dispatchRole(String userId, String roleIds) {
//        ArrayList roleList=fenGeByDouHao(roleIds);
//        System.out.println(userId+"***userID");
//        if(userRepository.findOneById(userId).size()==0){
//            return ResultUtil.error(405,"用户ID不存在",0);
//        }
//
//        if (roleList.size()==0){
//            return ResultUtil.error(404,"角色ID不存在",0);
//        }
//
//        try {
//            for (int i=0;i<roleList.size();i++){
//
//                roleRepository.dispatch(createID(),userId,roleList.get(i).toString());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResultUtil.error(500,"参数异常或缺失",0);
//        }
//        return ResultUtil.success(1,"角色分配");
//
//    }
//
//    @Override
//    public Result dispatchRole(String userId, Role role) {
//        String roleId=role.getRoleId();
//        if(roleRepository.findOneOfRoleByRoleId(roleId).size()==0){
//            return ResultUtil.error(404,"角色ID不存在",0);
//        }
//
//        if (userRepository.findOneById(userId).size()==0){
//            return ResultUtil.error(405,"用户ID不存在",0);
//        }
//
//        try {
//                roleRepository.dispatch(createID(),userId,roleId);
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResultUtil.error(500,"参数异常或缺失",0);
//        }
//        return ResultUtil.success(3,"角色分配");
//    }
//
//    @Override
//    public Result deletePermissionAll(String roleId) {
//        if (roleRepository.findOneOfRoleByRoleId(roleId).size()==0){
//            return ResultUtil.error(404,"角色ID不存在",0);
//        }
//
//        try {
//            roleRepository.deletePermissionAll(roleId);
//        }catch (Exception e){
//            return ResultUtil.error(000,"未知错误",0);
//        }
//
//        return ResultUtil.success(1,"删除角色下所有权限");
//    }
//
//    @Override
//    public Result deletePermissionOne(String roleId, String permissionId) {
//        if (roleRepository.findOneOfRoleByRoleId(roleId).size()==0){
//            return ResultUtil.error(404,"角色ID不存在",0);
//        }
//
//        if (permissionRepository.findOneById(permissionId).size()==0){
//            return ResultUtil.error(405,"权限ID不存在",0);
//        }
//
//        try {
//            roleRepository.deletePermissionOne(roleId,permissionId);
//        }catch (Exception e){
//            return ResultUtil.error(000,"未知错误",0);
//        }
//
//        return ResultUtil.success(1,"删除角色下所有权限");
//    }
//
//
//    /**
//     * 获取角色ID再查询角色
//     * @param listTemp
//     * @return
//     */
//    public List getRoleList(List<RoleRoot> listTemp){
//        List idList=new ArrayList();
//
//        /**
//         这个tip是判断roleId是否已经存在
//         **/
//        int tip=0;
//
//        for(int i=0;i<listTemp.size();i++){
//            for(int j=0;j<idList.size();j++){
//                if(listTemp.get(i).getRoleId().equals(idList.get(j))){
//                    tip++;
//                }
//            }
//
//            if(tip==0){
//                idList.add(listTemp.get(i).getRoleId());
//
//            }tip=0;
//        }
//
//        List<Role> roleList =new ArrayList<>();
//        for (int i = 0;i<idList.size();i++){
//            roleList.add(roleRepository.findOneOfRoleByRoleId(String.valueOf(idList.get(i))).get(0));
//        }
//
//        return roleList;
//    }
//
//
//    /**
//     * 生成角色树
//     */
//    public Map<String,Object> getRoleTree(List<Role> roleList){
//        List<Map<String,Object>> mapList=new ArrayList<>();
//        List<Map<String,Object>> rootRoles=new ArrayList<>();
//
//        for (int i=0;i<roleList.size();i++ ){
//            if(roleList.get(i).getState()==null||roleList.get(i).getState()==0){
//                continue;
//            }
//            Map<String,Object> map=new HashMap<>();
//            map.put("role_id",roleList.get(i).getRoleId());
//            map.put("role_name",roleList.get(i).getRoleName());
//            mapList.add(map);
//            if (roleList.get(i).getSuperRole()==null){
//                System.out.println(roleList.get(i).getRoleId()+"******");
//                rootRoles.add(map);
//            }
//        }
//
//        for(int i=0;i<roleList.size();i++){
//            if(roleList.get(i).getSuperRole()==null){
//                continue;
//            }
//            for(int j=0;j<roleList.size();j++){
//                if(roleList.get(i).getSuperRole().equals(roleList.get(j).getRoleId())){
//                    mapList.get(j).put("children",mapList.get(i));
//                    break;
//                }
//            }
//        }
//
//
//
//        Map<String,Object> roleTree=new HashMap();
//
//        if(rootRoles.size()==0){
//            roleTree.put("list",mapList);
//        }else {
//            roleTree.put("list",rootRoles);
//        }
//
//        return roleTree;
//    }
//
//
//    /**
//     * 分割逗号分隔的字符串
//     * @param str
//     * @return
//     */
//    public ArrayList fenGeByDouHao(String str){
//        ArrayList list=new ArrayList();
//        String tempId="";
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)==','){
//                list.add(tempId);
//                tempId="";
//                continue;
//            }
//            tempId+=str.charAt(i);
//        }
//        if(tempId.length()!=0){
//            list.add(tempId);
//        }
//        return list;
//    }
//
//
//
//    @Override
//    public List test1(){
//        return roleRepository.findAllOfRole();
//    }
//
//
//}
