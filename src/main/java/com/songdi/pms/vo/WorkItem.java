package com.songdi.pms.vo;

import java.io.Serializable;

public class WorkItem  implements Serializable {
    private String name;
    private int allHour;
    private String residueHour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllHour() {
        return allHour;
    }

    public void setAllHour(int allHour) {
        this.allHour = allHour;
    }

    public String getResidueHour() {
        return residueHour;
    }

    public void setResidueHour(String residueHour) {
        this.residueHour = residueHour;
    }
}
