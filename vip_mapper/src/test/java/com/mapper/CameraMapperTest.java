package com.mapper;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import model.Camera;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mapper.xml"})
public class CameraMapperTest {

    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    @Autowired
    private DataSource dataSource;

    @Autowired
    private CameraMapper mapper;

    @Before
    public void setUp() {
        Operation operation = Operations.sequenceOf(
                Operations.deleteAllFrom("camera"),
                Operations.insertInto("camera")
                        .columns("id", "store_name", "customer_id", "customer_age", "customer_sex", "data_generate_time", "camera_id", "camera_name", "catch_area")
                        .values(785688, "唯品会长沙门店", "87016", 23, 2, "2018-12-30 22:33:42", "137898601067", "摄像机6", "进门")
                        .values(785689, "唯品会北京门店", "87016", 23, 2, "2018-12-30 22:33:42", "137898601067", "摄像机6", "进门")
                        .values(785690, "唯品会长春门店", "87016", 23, 2, "2018-12-30 22:33:42", "137898601067", "摄像机6", "进门")
                        .build()
        );
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbSetupTracker.launchIfNecessary(dbSetup);
    }

    @Test
    public void selectOne() {
        dbSetupTracker.skipNextLaunch();
        Camera camera = new Camera();
        camera.setId(785688);
        Camera res = mapper.selectOne(camera);
        System.out.println(res);
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