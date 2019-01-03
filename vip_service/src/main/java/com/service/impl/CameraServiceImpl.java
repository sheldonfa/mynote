package com.service.impl;

import com.exception.DataFormatException;
import com.mapper.CameraMapper;
import com.service.CameraService;
import entity.statsInfo.HourStat;
import entity.statsInfo.StatsResultInfo;
import model.Camera;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void insertFromCsv(String path) throws IOException, SQLException {
        // 解析
        List<Camera> cameras = parseCsv(path);
        // 验证
        Camera camera = cameras.get(0);
        List<Camera> cameraList = cameraMapper.select(camera);
        if (cameraList.size() > 0) {
            throw new FileAlreadyExistsException("文件已经加载过");
        }
        int index = 0;
        while (cameras.size() > index + 10) {
            cameraMapper.insertAll(cameras.subList(index, index + 10));
            index += 10;
        }
        cameraMapper.insertAll(cameras.subList(index, cameras.size()));
    }

    private List<Camera> parseCsv(String path) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Camera> results = new ArrayList<>();
        String line;
        int num = 0;
        while ((line = br.readLine()) != null) {
            num++;
            if (num == 1) {
                continue;
            }
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
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                try {
                    Date date2 = df2.parse(values[4]);
                    camera.setDataGenerateTime(new Timestamp(date2.getTime()));
                } catch (ParseException e1) {
                    e1.printStackTrace();
                    br.close();
                    throw new DataFormatException("日期格式：" + values[4] + "解析失败，要求yyyy-MM-dd HH:mm:ss 或者yyy/MM/dd");
                }
            }
            camera.setCameraId(values[5]);
            camera.setCameraName(values[6]);
            camera.setCatchArea(values[7]);
            results.add(camera);
        }
        br.close();
        return results;
    }

    @Override
    public Long statsRepeat(String storeName, Long startTimeLong, Long endTimeLong) {
        return cameraMapper.countRepeat(storeName, new Timestamp(startTimeLong), new Timestamp(endTimeLong));
    }

    public Integer statsPeakHour(String storeName, Long startTimeLong, Long endTimeLong) {
        List<HourStat> maps = cameraMapper.statsHoursCount(storeName, new Timestamp(startTimeLong), new Timestamp(endTimeLong));
        if (maps.size() > 0) {
            maps.sort((o1, o2) -> {
                return o1.getCount() < o2.getCount() ? 1 : -1;
            });
            HourStat hourStat = maps.get(0);
            return hourStat.getHour();
        }
        return null;
    }

    @Override
    public StatsResultInfo statsResult(String storeName, Long startTime, Long endTime) {
        // 计算重复到店
        Long repeatCount = statsRepeat(storeName, startTime, endTime);
        Integer peakHour = statsPeakHour(storeName, startTime, endTime);
        StatsResultInfo res = new StatsResultInfo();
        res.setRepeatCount(repeatCount);
        res.setPeakHour(peakHour);
        return res;
    }

    @Override
    public void deleteAll() {
        cameraMapper.deleteAll();
    }
}
