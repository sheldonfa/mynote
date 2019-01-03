package com.service;

import model.Camera;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class CameraServiceTest {

    @Autowired
    private CameraService cameraService;

    @Test
    public void testSelectAll() {
        List<Camera> cameras = cameraService.selectAll();
        for (Camera c : cameras) {
            System.out.println(c);
        }
    }

    @Test
    public void testDeleteAll(){
        cameraService.deleteAll();
    }
}