package com.oliver;

import static com.oliver.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
//        super.run();
        System.out.println(ANSI_BLUE + "hello from" + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "3 sec passed");
    }
}
