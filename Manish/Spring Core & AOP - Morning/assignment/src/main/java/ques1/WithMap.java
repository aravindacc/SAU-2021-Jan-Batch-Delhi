package ques1;

import java.util.Map;

public class WithMap {

    private Map<Integer, String> map;

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "WithMap{" +
                "map=" + map +
                '}';
    }
}
