package org.mja123;

public enum EPages {
    FORM_LOGIN("Form Authentication"),
    DROPDOWN("Dropdown"),
    FRAMES("Frames");

    private String text;
    EPages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
