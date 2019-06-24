package lml.lml.service;

import lml.lml.domain.Column;
import lml.lml.domain.Result;

public interface ColumnService {
    Result findAll();

    Result findOneByNo(String columnNo);

    Result deleteColumn(Column column);

    Result deleteColumn(String columnNo);

    Result updateColumn(Column column);

    Result addColumn(Column column);
}
