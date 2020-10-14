package online.goudan;

import javafx.concurrent.Worker;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author chenglongliu
 * @date 2020/10/13 19:28
 * @desc 线程池的使用
 */
public class ThreadPoolTest {

    private ThreadPoolExecutor poolExecutor;

    @Before
    public void init() throws Exception {
        poolExecutor = new ThreadPoolExecutor(3, 20, 10, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(300), new ThreadFactory() {
            int threadNum = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThread" + threadNum);
                threadNum++;
                return thread;
            }
        });
    }

    @Test
    public void test01() throws Exception {

        for (int i = 0; i < 300; i++) {
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
        Thread.sleep(Integer.MAX_VALUE);

    }

    private volatile boolean flag;

    /**
     * volatile 只能保证可见性,不能保证原子性和有序性
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


}
