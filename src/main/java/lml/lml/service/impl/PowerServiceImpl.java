package lml.lml.service.impl;

import lml.lml.domain.Power;
import lml.lml.domain.PowerAndRole;
import lml.lml.domain.Result;
import lml.lml.repository.PowerAndRoleRepository;
import lml.lml.repository.PowerRepository;
import lml.lml.service.PowerService;
import lml.lml.utils.EntityIDFactory;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerRepository powerRepository;

    @Autowired
    PowerAndRoleRepository powerAndRoleRepository;

    @Override
    public Result findAll() {
        return ResultUtil.success(powerRepository.findAll());
    }

    @Override
    public Result deletePower(Power power) {
        return deletePower(power.getPowerNo());
    }

    @Override
    public Result deletePower(String powerNo) {
        return ResultUtil.success(powerRepository.deleteByPowerNo(powerNo));
    }

    @Override
    public Result updatePower(Power power) {
        return ResultUtil.success(powerRepository.editPower(power));
    }

    @Override
    public Result addPower(Power power) {
        return ResultUtil.success(powerRepository.editPower(power));
    }

    @Override
    public Result findOneByNo(String powerNo) {
        return ResultUtil.success(powerRepository.findOneByNo(powerNo));
    }

    @Override
    public Result editPower(PowerAndRole powerAndRole) {
        return ResultUtil.success(powerAndRoleRepository.edit(powerAndRole));
    }

    @Override
    public Result removePower(PowerAndRole powerAndRole) {
        return ResultUtil.success(powerAndRoleRepository.remove(powerAndRole.getRoleNo(),powerAndRole.getPowerNo()));
    }

    @Override
    public Result findByRoleNo(String roleNo) {
        return ResultUtil.success(powerRepository.findByRoleNo(roleNo));
    }

    @Override
    public Result setPower(PowerAndRole powerAndRole) {
        List<PowerAndRole> tempList=powerAndRoleRepository.findByRoleNo(powerAndRole.getRoleNo());
        boolean flag=false;
        for (int i=0;i<tempList.size();i++){
            if(tempList.get(i).getPowerNo().equals(powerAndRole.getPowerNo())){
                flag=true;
            }
        }
        powerAndRole.setNo(EntityIDFactory.createID());
        boolean rs;
        if(flag){
            rs=powerAndRoleRepository.remove(powerAndRole.getRoleNo(),powerAndRole.getPowerNo());
        }else {

            rs=powerAndRoleRepository.edit(powerAndRole);
        }

        return ResultUtil.success(rs);
    }
}
