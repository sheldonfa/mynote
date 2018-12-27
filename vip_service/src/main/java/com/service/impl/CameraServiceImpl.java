package com.service.impl;

import com.exception.DataFormatException;
import com.mapper.CameraMapper;
import com.service.CameraService;
import entity.StatsResultInfo;
import model.Camera;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author fangxin
 * @date 2017/11/5.
 */
@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraMapper cameraMapper;

    @Override
    public List<Camera> selectAll() {
        return cameraMapper.selectAll();
    }

    @Override
    public void parseCsv(String path) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<Camera> cameras = new ArrayList<Camera>();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            assert values.length == 8;
            Camera camera = new Camera();
            camera.setStoreName(values[0]);
            camera.setCustomerId(values[1]);
            try {
                camera.setCustomerAge(Integer.parseInt(values[2]));
            } catch (Exception e) {
                camera.setCustomerAge(null);
            }
            if (StringUtils.equals(values[3], "男")) {
                camera.setCustomerSex(1);
            } else if (StringUtils.equals(values[3], "女")) {
                camera.setCustomerSex(2);
            } else {
                camera.setCustomerSex(null);
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = df.parse(values[4]);
                camera.setDataGenerateTime(new Timestamp(date.getTime()));
            } catch (ParseException e) {
                throw new DataFormatException("日期格式：" + values[4] + "解析失败，要求yyyy-MM-dd HH:mm:ss");
            }
            camera.setCameraId(values[5]);
            camera.setCameraName(values[6]);
            camera.setCatchArea(values[7]);
            cameras.add(camera);
            if (cameras.size() > 10) {
                try {
                    cameraMapper.insertAll(cameras);
                } catch (Exception e) {
                    br.close();
                    e.printStackTrace();
                    throw new SQLException();
                }
                cameras.clear();
            }
        }
        if (cameras.size() > 0) {
            cameraMapper.insertAll(cameras);
        }
    }

    @Override
    public Long statsRepeat(Long startTimeLong, Long endTimeLong) {
        return cameraMapper.countRepeat(new Timestamp(startTimeLong), new Timestamp(endTimeLong));
    }

    public Long statsPeakHour(String storeName, Long startTimeLong, Long endTimeLong) {
        List<Map<String, String>> maps = cameraMapper.statsHoursCount(storeName, startTimeLong, endTimeLong);
        Integer max = 0;
        maps.sort((o1, o2) -> {
            Integer count1 = Integer.parseInt(o1.get("count"));
            Integer count2 = Integer.parseInt(o2.get("count"));
            return count1 > count2 ? 1 : 0;
        });
        Map<String, String> res = maps.get(0);
        return Long.parseLong(res.get("period"));
    }

    @Override
    public StatsResultInfo statsResult(String filePath, String storeName, Long startTime, Long endTime) {
        // 计算重复到店
        Long repeatCount = statsRepeat(startTime, endTime);
        Long peakHour = statsPeakHour(storeName, startTime, endTime);
        StatsResultInfo res = new StatsResultInfo();
        res.setRepeatCount(repeatCount);
        res.setPeakHour(peakHour);
        return res;
    }
}
