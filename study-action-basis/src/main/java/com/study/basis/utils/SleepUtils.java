package com.study.basis.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author valiantzh
 * @version 1.0
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
