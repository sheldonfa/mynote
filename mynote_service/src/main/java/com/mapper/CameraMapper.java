package com.mapper;

import model.Camera;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CameraMapper {

    List<Camera> selectAll();

    void insertAll(@Param("cameras") List<Camera> cameras);

    String selectDatabase();
}
