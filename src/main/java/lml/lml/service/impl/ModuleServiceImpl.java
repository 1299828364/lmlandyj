package lml.lml.service.impl;

import lml.lml.domain.Module;
import lml.lml.domain.Result;
import lml.lml.repository.ModuleRepository;
import lml.lml.service.ModuleService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public Result findAll() {
        return ResultUtil.success(moduleRepository.findAll());
    }

    @Override
    public Result deleteModule(Module module) {
        return deleteModule(module.getModuleNo());
    }

    @Override
    public Result deleteModule(String moduleNo) {
        return ResultUtil.success(moduleRepository.deleteByModuleNo(moduleNo));
    }

    @Override
    public Result updateModule(Module module) {
        return ResultUtil.success(moduleRepository.editModule(module));
    }

    @Override
    public Result addModule(Module module) {
        return ResultUtil.success(moduleRepository.editModule(module));
    }

    @Override
    public Result findOneByNo(String moduleNo) {
        return ResultUtil.success(moduleRepository.findOneByNo(moduleNo));
    }
}
