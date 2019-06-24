package lml.lml.repository;

import lml.lml.domain.Column;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ColumnRepository {
    List<Column> findAll();

    Column findOneByNo(@Param("ColumnNo")String columnNo);

    boolean editColumn(Column power);

    boolean deleteByColumnNo(@Param("ColumnNo")String columnNo);
}
