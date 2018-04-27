package com.guoziwei.klinelib.model;

/**
 * chart data model
 */

public class HisData {

    private double close;
    private double high;
    private double low;
    private double open;
    private long vol;
    private long date;
    private long amountVol;
    private double avePrice;
    private double total;
    private double maSum;
    private double ma5;
    private double ma10;
    private double ma20;
    private double ma30;

    private double dif;
    private double dea;
    private double macd;

    private double k;
    private double d;
    private double j;

    public double getDif() {
        return dif;
    }



    public HisData() {
    }

    public HisData(double open,double close, double high, double low,  long vol, long date) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.vol = vol;
        this.date = date;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public long getVol() {
        return vol;
    }

    public void setVol(long vol) {
        this.vol = vol;
    }


    public double getAvePrice() {
        return avePrice;
    }

    public void setAvePrice(double avePrice) {
        this.avePrice = avePrice;
    }


    public long getAmountVol() {
        return amountVol;
    }

    public void setAmountVol(long amountVol) {
        this.amountVol = amountVol;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getMa30() {
        return ma30;
    }

    public void setMa30(double ma30) {
        this.ma30 = ma30;
    }


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HisData data = (HisData) o;

        return date == data.date;
    }

    @Override
    public int hashCode() {
        return (int) (date ^ (date >>> 32));
    }

    public double getMaSum() {
        return maSum;
    }

    public void setMaSum(double maSum) {
        this.maSum = maSum;
    }

    public void setDif(double dif) {
        this.dif = dif;
    }

    public double getDea() {
        return dea;
    }

    public void setDea(double dea) {
        this.dea = dea;
    }

    public double getMacd() {
        return macd;
    }

    public void setMacd(double macd) {
        this.macd = macd;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"close\":")
                .append(close);
        sb.append(",\"high\":")
                .append(high);
        sb.append(",\"low\":")
                .append(low);
        sb.append(",\"open\":")
                .append(open);
        sb.append(",\"vol\":")
                .append(vol);
        sb.append(",\"date\":")
                .append(date);
        sb.append(",\"amountVol\":")
                .append(amountVol);
        sb.append(",\"avePrice\":")
                .append(avePrice);
        sb.append(",\"total\":")
                .append(total);
        sb.append(",\"maSum\":")
                .append(maSum);
        sb.append(",\"ma5\":")
                .append(ma5);
        sb.append(",\"ma10\":")
                .append(ma10);
        sb.append(",\"ma20\":")
                .append(ma20);
        sb.append(",\"ma30\":")
                .append(ma30);
        sb.append(",\"dif\":")
                .append(dif);
        sb.append(",\"dea\":")
                .append(dea);
        sb.append(",\"macd\":")
                .append(macd);
        sb.append(",\"k\":")
                .append(k);
        sb.append(",\"d\":")
                .append(d);
        sb.append(",\"j\":")
                .append(j);
        sb.append('}');
        return sb.toString();
    }

}
