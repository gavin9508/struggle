package com.struggle.design.builder.demo1;

public class House {
    private String diJi;
    private String gangJin;
    private String shuiNi;

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
