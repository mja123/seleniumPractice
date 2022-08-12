package org.mja123.waits;

import org.mja123.frames.EFrames;

public enum EWait {
    HIDDEN("rendered"),
    RENDERED("hidden");

    private String text;

    EWait(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public EWait getElement(EWait element) {
        return element;
    }
}
