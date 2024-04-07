package _1115;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1 LinkedBlockingQueue
 * 2 CyclicBarrier
 * 3 自旋+yield
 * 4 可重入锁 ReentrantLock + Condition
 * 5 synchronized + 标志位 + 唤醒
 * 6 信号量 Semaphore
 * 7 wait() + notifyAll()
 * 8 无锁
 */
class FooBar {
    private int n;
    private LinkedBlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);
    private LinkedBlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            foo.put(i);
        	printFoo.run();
            bar.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            foo.take();
        	printBar.run();
            bar.take();
        }
    }



    public static void main(String[] args) throws RuntimeException{
        final FooBar fooBar = new FooBar(2);
        new Thread(() -> {
            try {
                fooBar.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

