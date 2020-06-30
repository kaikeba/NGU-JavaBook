package com.kaikeba.bean;


/**
 * 快递类。
 * 每一个快递类的对象表示一个快递信息
 * @author liweijie
 */
public class Express {
    //快递公司
    private String company;
    //快递单号码
    private String number;
    //收件人手机号码
    private String phoneNumber;
    //取件码
    private int extractionCode;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getExtractionCode() {
        return extractionCode;
    }

    public void setExtractionCode(int extractionCode) {
        this.extractionCode = extractionCode;
    }

    public Express() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
