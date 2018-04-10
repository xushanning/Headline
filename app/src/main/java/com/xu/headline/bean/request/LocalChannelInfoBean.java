package com.xu.headline.bean.request;

import java.util.List;

/**
 * @author 言吾許
 * 获取频道信息（已订阅频道和推荐频道）的时候，带着的body
 */

public class LocalChannelInfoBean {

    /**
     * city : 城市
     * latitude : 39.954137125566774
     * longitude : 116.34467192776384
     * loc_time : 1523200921
     * categories : ["xx","xx"]
     * iid : 29858226621
     * device_id : 37717988923
     * device_platform : android
     */

    private String city;
    private double latitude;
    private double longitude;
    private int loc_time;
    private long iid;
    private long device_id;
    private String device_platform;
    private List<String> categories;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getLoc_time() {
        return loc_time;
    }

    public void setLoc_time(int loc_time) {
        this.loc_time = loc_time;
    }

    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public String getDevice_platform() {
        return device_platform;
    }

    public void setDevice_platform(String device_platform) {
        this.device_platform = device_platform;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
