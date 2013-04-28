package com.github.xxiii.boerse.stock;

public enum Stock {


    ADIDAS("ADS"),
    ALLIANZ("ALV"),
    BASF("BAS"),
    BAYER("BAYN"),
    BMW("BMW"),
    COMMERZBANK("CBK"),
    DAIMLER("DAI"),
    DEUTSCHE_BANK("DBK"),
    DEUTSCHE_TELEKOM("DTE"),
    FRESENIUS_MEDICAL_CARE("FME"),
    HENKEL("HEN"),
    LINDE("LIN"),
    RWE("RWE"),
    SAP("SAP"),
    SIEMENS("SIE"),
    THYSSEN_KRUPP("TKA"),
    VOLKSWAGEN("VOW");
    private final String googleFinanceCode;

    Stock(String googleFinanceCode) {
        this.googleFinanceCode = googleFinanceCode;
    }

    public String getGoogleFinanceCode() {
        return googleFinanceCode;
    }


}
