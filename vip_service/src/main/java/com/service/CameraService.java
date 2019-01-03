package com.service;

import entity.common.Result;
import entity.statsInfo.StatsResultInfo;
import model.Camera;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fangxin
 * @date 2017/11/5.
 */
public interface CameraService {

    /**
     * 查询全部
     *
     * @return
     */
    List<Camera> selectAll();

    /**
     * 解析csv文件
     *
     * @param path 获取文件
     * @throws IOException
     * @throws SQLException
     */
    void insertFromCsv(String path) throws IOException, SQLException;

    /**
     * 重复到店
     */
    Long statsRepeat(String storeName, Long startTime, Long endTime);

    StatsResultInfo statsResult(String storeName, Long startTime, Long endTime);

    void deleteAll();
}
