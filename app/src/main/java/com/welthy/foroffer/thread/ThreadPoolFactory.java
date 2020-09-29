package com.welthy.foroffer.thread;

public class ThreadPoolFactory {

    private static ThreadPoolFactory mInstance;
    private ThreadPoolFactory(){}

    public static ThreadPoolFactory getInstance() {
        if (mInstance == null) {
            synchronized (ThreadPoolFactory.class) {
                if (mInstance == null) {
                    mInstance = new ThreadPoolFactory();
                }
            }
        }
        return mInstance;
    }

    public ThreadPoolProxy getThreadProxy(int coreThreads) {
        return new ThreadPoolProxy(coreThreads);
    }

    public ThreadPoolProxy getThreadProxy() {
        return new ThreadPoolProxy();
    }
}
