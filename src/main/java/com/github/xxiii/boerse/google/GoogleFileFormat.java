package com.github.xxiii.boerse.google;

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
