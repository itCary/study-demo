package online.goudan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author chenglongliu
 * @date 2020/10/13 19:28
 * @desc 线程池的使用
 */
public class ThreadPoolTest {

    private ThreadPoolExecutor poolExecutor;
    private long startTime;
    private long endTime;

    @Before
    public void init() throws Exception {
        poolExecutor = new ThreadPoolExecutor(20, 10000, 10, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1000), new ThreadFactory() {
            int threadNum = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThread" + threadNum);
                threadNum++;
                return thread;
            }
        });
        boolean b = poolExecutor.prestartCoreThread();
        if (b) {
            startTime = System.currentTimeMillis();
        }
    }

    @After
    public void destroy() {
        endTime = System.currentTimeMillis();
        System.out.printf("耗费时间：%.2fs%n", (endTime - startTime) / 1000d);
    }

    @Test
    public void test01() throws Exception {

        for (int i = 0; i < 3000; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    private volatile boolean flag;

    /**
     * volatile 只能保证可见性,不能保证原子性和有序性
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        flag = true;
        poolExecutor.execute(() -> {
            while (flag) {
                try {
                    Thread.sleep(3000L);
                    System.out.printf("%s,%d,%b%n", Thread.currentThread().getName(), System.currentTimeMillis(), flag);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        poolExecutor.execute(() -> {
            try {
                Thread.sleep(10 * 1000);
                flag = false;
                System.out.printf("%s,%d,%b%n", Thread.currentThread().getName(), System.currentTimeMillis(), flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test03() throws Exception {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                sum += 1;
            }).start();
        }
        System.out.printf("sum:%d%n", sum);
    }

    int sum = 0;

    @Test
    public void test04() {

        for (int i = 0; i < 100000; i++) {
            poolExecutor.execute(() -> {
                sum += 1;
            });
        }

        System.out.printf("sum:%d%n", sum);

    }

    @Test
    public void test05() {
        for (int i = 0; i < 100000; i++) {
            sum += 1;
        }
        System.out.printf("sum:%d%n", sum);

    }
}
