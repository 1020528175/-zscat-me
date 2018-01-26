package com.zsCat.common.base;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by summer on 2016/11/29.
 */
public class RabbitMsg implements Serializable{

    private String type;

    private Map map;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "RabbitMsg{" +
                "type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}
