package com.mapper;

import entity.common.Result;
import entity.statsInfo.HourStat;
import model.Camera;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CameraMapper extends Mapper<Camera> {

    List<Camera> selectAll();

    void insertAll(@Param("cameras") List<Camera> cameras);

    String selectDatabase();

    /**
     * 重复到店
     */
    Long countRepeat(@Param("storeName") String storeName, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);

    /**
     * 高峰期
     */
    List<HourStat> statsHoursCount(@Param("storeName") String storeName, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);

    void deleteAll();
}
