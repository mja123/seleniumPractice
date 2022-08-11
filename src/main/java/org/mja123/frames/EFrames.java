package org.mja123.frames;

public enum EFrames {
    NESTED("Nested Frames"),
    IFRAME("iFrame");

    private final String frame;
    EFrames(String frame) {
        this.frame = frame;
    }
    public String getFrame() {
        return frame;
    }
}
