package _1115.spin_yield;

/**
 * https://leetcode.cn/problems/print-foobar-alternately/solutions/542996/duo-xian-cheng-liu-mai-shen-jian-ni-xue-d220n/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * 1 LinkedBlockingQueue
 * 2 CyclicBarrier
 * 【3】 自旋+Thread.yield() 让出cpu
 * 4 可重入锁 ReentrantLock + Condition
 * 5 synchronized + 标志位 + 唤醒
 * 6 信号量 Semaphore
 * 7 wait() + notifyAll()
 * 8 无锁
 */
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean allowFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (allowFoo) {
                printFoo.run();
                i++;
                allowFoo = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {

            if (!allowFoo) {
                printBar.run();
                i++;
                allowFoo = true;
            } else {
                Thread.yield();
            }
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