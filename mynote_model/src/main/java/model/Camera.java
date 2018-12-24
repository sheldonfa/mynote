package model;

import java.sql.Timestamp;
import java.util.Date;

public class Camera {

    private Integer id;
    // 门店名称
    private String storeName;
    // 顾客id
    private String customerId;
    // 顾客年龄
    private Integer customerAge;
    // 顾客性别 1男性 2女性
    private Integer customerSex;
    // 数据生成时间
    private Timestamp dataGenerateTime;
    // 摄像头id
    private String cameraId;
    // 摄像头名称
    private String cameraName;
    // 捕捉区域
    private String catchArea;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public Integer getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }

    public Timestamp getDataGenerateTime() {
        return dataGenerateTime;
    }

    public void setDataGenerateTime(Timestamp dataGenerateTime) {
        this.dataGenerateTime = dataGenerateTime;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCatchArea() {
        return catchArea;
    }

    public void setCatchArea(String catchArea) {
        this.catchArea = catchArea;
    }

    public Camera() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerAge=" + customerAge +
                ", customerSex=" + customerSex +
                ", dataGenerateTime=" + dataGenerateTime +
                ", cameraId='" + cameraId + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", catchArea='" + catchArea + '\'' +
                '}';
    }
}
