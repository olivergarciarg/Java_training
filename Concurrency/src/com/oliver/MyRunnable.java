package com.oliver;

import static com.oliver.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "from MyRunnables");
    }
}
