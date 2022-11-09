package com.oliver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.oliver.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
//        List<String> buffer =  new ArrayList<>();
        ArrayBlockingQueue<String> buffer =  new ArrayBlockingQueue<>(6);
//        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer1 =new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 =new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);


        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_BLUE + "from callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("something went wrong");
        } catch (InterruptedException e) {
            System.out.println("thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
//    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock bufferLock;

//    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for (String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);

//                bufferLock.lock();
                buffer.put(num);
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e ) {
                System.out.println("Producer interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
//        bufferLock.lock();
        try {
//            buffer.add(EOF);
            buffer.put(EOF);
        } catch (InterruptedException e) {

        }
//        finally {
//            bufferLock.unlock();
//        }
    }
}

class MyConsumer implements Runnable {
//    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock bufferLock;

//    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.bufferLock = bufferLock;
    }

    public  void run() {
//        int counter = 0;

        while(true) {
//            if (bufferLock.tryLock()) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
//                    System.out.println(color + "counter = " + counter);
//                    counter = 0;
//                    if (buffer.get(0).equals(EOF)) {
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
//                        System.out.println(color + "Removed" + buffer.remove(0));
                        System.out.println(color + "Removed" + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }

//                finally {
//                    bufferLock.unlock();
//                }
//            } else {
//                counter++;
//            }
        }
    }
}