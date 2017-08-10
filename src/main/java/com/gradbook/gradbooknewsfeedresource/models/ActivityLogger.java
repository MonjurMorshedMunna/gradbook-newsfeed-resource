package com.gradbook.gradbooknewsfeedresource.models;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Monjur-E-Morshed on 10-Aug-17.
 */
public class ActivityLogger {



    private String userId;

    private Timestamp accessTime;

    private String className;

    private String methodName;

    private static final AtomicLong count = new AtomicLong(0);

    public ActivityLogger() {
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public Timestamp getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Timestamp pAccessTime) {
        accessTime = pAccessTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String pClassName) {
        className = pClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String pMethodName) {
        methodName = pMethodName;
    }
}
