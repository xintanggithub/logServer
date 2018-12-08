package com.jidouauto.log.model;

public class AppInfoByHeaderEntity {

    public static final String X_AUTH_DEVICE_TYPE = "X-AUTH-DEVICE-TYPE";
    public static final String X_AUTH_CHANNEL = "channel";
    public static final String X_AUTH_APP_NAME = "appName";
    public static final String X_AUTH_PACKAGE_NAME = "packageName";
    public static final String X_AUTH_VERSION_CODE = "versionCode";
    public static final String X_AUTH_VERSION_NAME = "versionName";

    private String channel;
    private String appName;
    private String packageName;
    private int versionCode;
    private String versionName;
    private String deviceType;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
