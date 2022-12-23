package com.example.demo.data.repository;

import com.example.demo.data.entity.DataEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataRepository {

    //DB에 데이터 넣기
     boolean uploadData(DataEntity dataEntity);
}
