package lml.lml.service;

import lml.lml.domain.Power;
import lml.lml.domain.PowerAndRole;
import lml.lml.domain.Result;
import org.apache.ibatis.annotations.Param;

public interface PowerService {
    Result findAll();

    Result deletePower(Power power);

    Result deletePower(String powerNo);

    Result updatePower(Power power);

    Result addPower(Power power);

    Result findOneByNo(String powerNo);

    Result editPower(PowerAndRole powerAndRole);

    Result removePower(PowerAndRole powerAndRole);

    Result findByRoleNo(String roleNo);

    Result setPower(PowerAndRole powerAndRole);
}
