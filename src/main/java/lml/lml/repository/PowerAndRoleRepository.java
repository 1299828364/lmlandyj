package lml.lml.repository;


import lml.lml.domain.PowerAndRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerAndRoleRepository {

    boolean edit(PowerAndRole powerAndRole);

    boolean remove(@Param("roleNo")String roleNo,@Param("powerNo")String powerNo);

    List<PowerAndRole> findAll();

    List<PowerAndRole> findByRoleNo(String roleNo);
}
