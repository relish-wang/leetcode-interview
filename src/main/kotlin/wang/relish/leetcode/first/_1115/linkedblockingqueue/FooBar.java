package wang.relish.leetcode.first._1115.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.cn/problems/print-foobar-alternately/solutions/542996/duo-xian-cheng-liu-mai-shen-jian-ni-xue-d220n/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 *【1】 LinkedBlockingQueue
 * 2 CyclicBarrier
 * 3 自旋+Thread.yield() 让出cpu
 * 4 可重入锁 ReentrantLock + Condition
 * 5 synchronized + flag + wait()/notifyAll()
 * 6 信号量 Semaphore
 * 7 无锁(仅flag) // 超时
 */
class FooBar {
    private int n;
    private final LinkedBlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);
    private final LinkedBlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            foo.put(i);// 容量为1, 上一个未消费(即take)的话, 就会阻塞在这里
        	printFoo.run(); // 打印foo
            bar.put(i); // 此时阻塞, 直到printBar.run()后面的那句bar.take()执行, 就是说bar打印后, 这里才开始往后执行。
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            foo.take(); // 如果foo为空, 则会等阻塞直到, foo.put()
        	printBar.run(); // 打印"bar"
            bar.take(); // 如果bar为空, 则会等阻塞直到, bar.put()
        }
    }



    public static void main(String[] args) throws RuntimeException{
        final FooBar fooBar = new FooBar(4);
        new Thread(() -> {
            try {
                fooBar.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

