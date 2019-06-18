package lml.lml.service.impl;//package com.example.lml.service.impl;
//
//import com.example.lml.demolml.domain.Feature;
//import com.example.lml.demolml.domain.Result;
//import com.example.lml.demolml.repository.FeatureRepository;
//import com.example.lml.demolml.service.FeatureService;
//import com.example.lml.demolml.utils.ResultUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class FeatureServiceImpl implements FeatureService {
//
//    @Autowired
//    FeatureRepository featureRepository;
//
//    @Override
//    public List<Feature> findAll(){
//        return featureRepository.findAll();
//    }
//
//    @Override
//    public Result<Feature> findOne(String id) {
//        return ResultUtil.success(featureRepository.findOne(id),"根据id获取功能");
//    }
//}
