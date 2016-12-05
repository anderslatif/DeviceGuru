package javaFX.util;

public enum Status {

    CREATED(1),
    REPORTED(2),
    SENT(3),
    CASE_CREATED(4),
    CASE_CLOSED(5);


    private int i;

    private Status(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }


}
