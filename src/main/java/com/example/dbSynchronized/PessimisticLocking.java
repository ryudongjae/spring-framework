package com.example.dbSynchronized;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PessimisticLocking {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int threadCnt = 35000;

    public static void main(String[] args) throws InterruptedException {
        log.info("notPessimisticLocking : " + notPessimisticLocking());
        log.info("pessimisticLocking : " + pessimisticLocking());
    }

    static int notPessimisticLockingCnt = 0;
    static int pessimisticLockingCnt = 0;
    public static String notPessimisticLocking() throws InterruptedException {

        Thread[] threads = new Thread[threadCnt];
        for (int i = 0; i < threadCnt; i++) {
            threads[i] = new Thread(() -> {
                notPessimisticLockingCnt++;
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        return "not Pessimistic Locking : " + notPessimisticLockingCnt;
    }

    public static String pessimisticLocking() throws InterruptedException {
        Thread[] threads = new Thread[threadCnt];
        for (int i = 0; i < threadCnt; i++) {
            threads[i] = new Thread(() -> {
                lock.lock();
                try {
                    pessimisticLockingCnt++;
                } finally {
                    lock.unlock();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        return "Pessimistic Locking : " + pessimisticLockingCnt;
    }
}
