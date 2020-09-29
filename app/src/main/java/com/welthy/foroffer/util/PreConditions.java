package com.welthy.foroffer.util;

public final class PreConditions {

    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
