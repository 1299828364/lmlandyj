package lml.lml.service;

import lml.lml.domain.Power;
import lml.lml.domain.Result;

public interface PowerService {
    Result findAll();

    Result deletePower(Power power);

    Result deletePower(String powerNo);

    Result updatePower(Power power);

    Result addPower(Power power);

    Result findOneByNo(String powerNo);
}
