package lml.lml.service;

import lml.lml.domain.Module;
import lml.lml.domain.Result;

public interface ModuleService {
    Result findAll();

    Result deleteModule(Module module);

    Result deleteModule(String moduleNo);

    Result updateModule(Module module);

    Result addModule(Module module);

    Result findOneByNo(String moduleNo);
}
