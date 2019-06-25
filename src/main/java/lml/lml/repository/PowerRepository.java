package lml.lml.repository;


import lml.lml.domain.Power;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerRepository {

    List<Power> findAll();

    Power findOneByNo(@Param("PowerNo")String powerNo);

    boolean editPower(Power power);

    boolean deleteByPowerNo(@Param("PowerNo")String powerNo);

    List<Power> findByRoleNo(@Param("roleNo")String roleNo);

}
