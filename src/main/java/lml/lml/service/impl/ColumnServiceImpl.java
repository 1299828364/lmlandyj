package lml.lml.service.impl;

import lml.lml.domain.Column;
import lml.lml.domain.Result;
import lml.lml.repository.ColumnRepository;
import lml.lml.service.ColumnService;
import lml.lml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    ColumnRepository columnRepository;


    @Override
    public Result findAll() {
        return ResultUtil.success(columnRepository.findAll());
    }

    @Override
    public Result findOneByNo(String columnNo) {
        return ResultUtil.success(columnRepository.findOneByNo(columnNo));
    }

    @Override
    public Result deleteColumn(Column column) {
        return deleteColumn(column.getCoLanmuNo());
    }

    @Override
    public Result deleteColumn(String columnNo) {
        return ResultUtil.success(columnRepository.deleteByColumnNo(columnNo));
    }

    @Override
    public Result updateColumn(Column column) {
        return ResultUtil.success(columnRepository.editColumn(column));
    }

    @Override
    public Result addColumn(Column column) {
        return ResultUtil.success(columnRepository.editColumn(column));
    }
}
