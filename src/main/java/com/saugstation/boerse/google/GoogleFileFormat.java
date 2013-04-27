package com.saugstation.boerse.google;

/**
 * Created with IntelliJ IDEA.
 * User: marti_000
 * Date: 28.04.13
 * Time: 01:22
 * To change this template use File | Settings | File Templates.
 */
public enum GoogleFileFormat {

    CSV("csv");
    private final String googleFormatName;

    GoogleFileFormat(String googleFormatName) {
        this.googleFormatName = googleFormatName;

    }

    public String getGoogleFormatName() {
        return googleFormatName;
    }
}
