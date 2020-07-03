package utils;

import java.util.ArrayList;
import java.util.List;

public class FailInfo {
    private int count = 0;
    private List<String> info = new ArrayList<>();
    private String bdd;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public String getBdd() {
        return bdd;
    }

    public void setBdd(String bdd) {
        this.bdd = bdd;
    }
}
