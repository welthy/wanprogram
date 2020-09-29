package com.welthy.foroffer.util;

public class ToolKit {

    private static ToolKit mInstance;
    private ToolKit() {}

    public static ToolKit getInstance() {
        if (mInstance == null) {
            synchronized (ToolKit.class) {
                if (mInstance == null) {
                    mInstance = new ToolKit();
                }
            }
        }
        return mInstance;
    }


}
