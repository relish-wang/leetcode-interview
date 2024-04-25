package wang.relish.leetcode.second._1115.linkedblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://leetcode.cn/problems/print-foobar-alternately/solutions/542996/duo-xian-cheng-liu-mai-shen-jian-ni-xue-d220n/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * 【1】 LinkedBlockingQueue
 * 2 CyclicBarrier
 * 3 自旋+Thread.yield() 让出cpu
 * 4 可重入锁 ReentrantLock + Condition
 * 5 synchronized + flag + wait()/notifyAll()
 * 6 信号量 Semaphore
 * 7 无锁(仅flag) // 超时
 */
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    ArrayBlockingQueue<Integer> foo = new ArrayBlockingQueue<>(1);
    ArrayBlockingQueue<Integer> bar = new ArrayBlockingQueue<>(1);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.offer(i);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.take();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            bar.offer(i);
        }
    }


    public static void main(String[] args) throws RuntimeException {
        final FooBar fooBar = new FooBar(4);
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

