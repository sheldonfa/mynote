package com.mapper;

import model.Camera;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class CameraMapperTest {

    @Autowired
    private CameraMapper mapper;

    @Before
    public void init() {
        String dataBase = mapper.selectDatabase();
        assert StringUtils.equals(dataBase, "vipmanage_test");
    }

    @Test
    public void testSelectAll() throws Exception {
        List<Camera> cameras = mapper.selectAll();
        for (Camera c : cameras) {
            System.out.println(c);
        }
    }

    @Test
    public void testInsertAll() {
        List<Camera> list = new ArrayList<Camera>();
        Camera camera1 = new Camera();
        Camera camera2 = new Camera();
        list.add(camera1);
        list.add(camera2);
        mapper.insertAll(list);
    }

}