package com.struggle.design.builder.demo2;

public class House {
    private String diJi = "地基";
    private String gangJin = "钢筋";
    private String shuiNi = "水泥";

    public void setDiJi(String diJi) {
        this.diJi = diJi;
    }

    public void setGangJin(String gangJin) {
        this.gangJin = gangJin;
    }

    public void setShuiNi(String shuiNi) {
        this.shuiNi = shuiNi;
    }

    @Override
    public String toString() {
        return "House{" +
                "diJi='" + diJi + '\'' +
                ", gangJin='" + gangJin + '\'' +
                ", shuiNi='" + shuiNi + '\'' +
                '}';
    }
}
