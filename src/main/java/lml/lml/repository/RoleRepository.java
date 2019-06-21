package lml.lml.repository;
import lml.lml.domain.Result;
import lml.lml.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository {
    List<Role> findAll();

    Role findOneByNo(@Param("roleNo")String roleNo);

    boolean editRole(Role role);

    boolean deleteByRoleNo(@Param("roleNo")String roleNo);



}
