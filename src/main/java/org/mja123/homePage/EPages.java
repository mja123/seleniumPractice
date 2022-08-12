package org.mja123.homePage;

public enum EPages {
    FORM_LOGIN("Form Authentication"),
    DROPDOWN("Dropdown"),
    HOVER("Hovers"),
    FRAMES("Frames"),
    FILE_UPLOADS("File Upload"),
    FILE_DOWNLOAD("File Download"),
    WAITS("Dynamic Loading"),
    ALERTS("JavaScript Alerts");


    private String text;
    EPages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public EPages getElement(EPages element) {
        return element;
    }
}
