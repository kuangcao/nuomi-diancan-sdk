package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 营业时间
 * Created by freeway on 16/9/8.
 */
public class BusinessTime implements Serializable {

    /**
     * 1:周1,2:周2,3:周3,4:周4,5:周5
     */
    @JSONField(name = "week")
    private List<Short> week;

    @JSONField(name = "time")
    private List<TimeScope> time;

    public List<Short> getWeek() {
        return week;
    }

    public void setWeek(List<Short> week) {
        this.week = week;
    }

    public List<TimeScope> getTime() {
        return time;
    }

    public void setTime(List<TimeScope> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BusinessTime{" +
                "week=" + week +
                ", time=" + time +
                '}';
    }

    public static class TimeScope {

        @JSONField(name = "startTime")
        private String startTime;

        @JSONField(name = "endTime")
        private String endTime;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "TimeScope{" +
                    "startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    '}';
        }
    }
}
