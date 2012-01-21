package org.rooinaction.coursemanager.types;

public class USPhoneNumber {

    private final String areaCode;
    private final String exchange;
    private final String number;

    public USPhoneNumber(String areaCode, String exchange, String number) {
        this.areaCode = areaCode;
        this.exchange = exchange;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getExchange() {
        return exchange;
    }

    public String getNumber() {
        return number;
    }

}
