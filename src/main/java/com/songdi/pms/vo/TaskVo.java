package com.songdi.pms.vo;

import java.io.Serializable;
import java.util.List;

public class TaskVo implements Serializable {
    private String name;
    private String date;
    private List<WorkItem> todayWork;
    private List<WorkItem> tomorrowWork;
    private int bugs;
    private int task;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<WorkItem> getTodayWork() {
        return todayWork;
    }

    public void setTodayWork(List<WorkItem> todayWork) {
        this.todayWork = todayWork;
    }

    public List<WorkItem> getTomorrowWork() {
        return tomorrowWork;
    }

    public void setTomorrowWork(List<WorkItem> tomorrowWork) {
        this.tomorrowWork = tomorrowWork;
    }

    public int getBugs() {
        return bugs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }
}
