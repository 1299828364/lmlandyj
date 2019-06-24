package lml.lml.service.impl;

import lml.lml.domain.Power;
import lml.lml.domain.Result;
import lml.lml.repository.PowerRepository;
import lml.lml.service.PowerService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerRepository powerRepository;

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
}
