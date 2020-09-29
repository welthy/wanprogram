package com.welthy.foroffer.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProxy {

    private static final int CPU_CNT = Runtime.getRuntime().availableProcessors();
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int MAX_CORE_THREAD = Math.max(2, Math.min(CPU_CNT * 2, 4));
    private static final long CORE_ALIVE_TIME = 3000;

    private ExecutorService mExecutor;

    private int mCoreThreads;

    public ThreadPoolProxy() {
        this(DEFAULT_CORE_THREADS);
    }

    public ThreadPoolProxy(int coreThreads) {
        this.mCoreThreads = coreThreads;
    }
    private void initExecutor() {
        if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()) {
            synchronized (this) {
                if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()) {
                    BlockingQueue threadQueue = new LinkedBlockingQueue();
                    mExecutor = new ThreadPoolExecutor(mCoreThreads,MAX_CORE_THREAD, CORE_ALIVE_TIME
                            , TimeUnit.MILLISECONDS,threadQueue);
                }
            }
        }
    }

    public void exec(Runnable r) {
        initExecutor();
        mExecutor.execute(r);
    }

    public void remove(Runnable r) {
        initExecutor();
        //mExecutor.re();
    }
}
