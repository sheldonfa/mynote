package com.service;

import model.Camera;

import java.io.IOException;
import java.util.List;

/**
 * @author fangxin
 * @date 2017/11/5.
 */
public interface CameraService {

    List<Camera> selectAll();

    void parseCsv(String path) throws IOException;
}
