package com.mapper;

import model.Camera;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CameraMapper extends Mapper<Camera> {

    List<Camera> selectAll();

    void insertAll(@Param("cameras") List<Camera> cameras);

    String selectDatabase();
}
