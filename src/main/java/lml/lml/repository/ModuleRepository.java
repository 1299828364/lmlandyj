package lml.lml.repository;

import lml.lml.domain.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository {
    List<Module> findAll();

    Module findOneByNo(@Param("ModuleNo")String moduleNo);

    boolean editModule(Module module);

    boolean deleteByModuleNo(@Param("ModuleNo")String moduleNo);
}
