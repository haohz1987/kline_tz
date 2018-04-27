package com.guoziwei.kline;

/**
 * Created by dell on 2017/11/23.
 */

public class Model {
    private double Close;
    private double High;
    private double Low;
    private double Open;
    private int Vol;
    private String sDate;

    public double getClose() {
        return Close;
    }

    public void setClose(double close) {
        Close = close;
    }

    public double getHigh() {
        return High;
    }

    public void setHigh(double high) {
        High = high;
    }

    public double getLow() {
        return Low;
    }

    public void setLow(double low) {
        Low = low;
    }

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        Open = open;
    }

    public int getVol() {
        return Vol;
    }

    public void setVol(int vol) {
        Vol = vol;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"Close\":")
                .append(Close);
        sb.append(",\"High\":")
                .append(High);
        sb.append(",\"Low\":")
                .append(Low);
        sb.append(",\"Open\":")
                .append(Open);
        sb.append(",\"Vol\":")
                .append(Vol);
        sb.append(",\"sDate\":\"")
                .append(sDate).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
