package online.goudan;

import javafx.concurrent.Worker;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenglongliu
 * @date 2020/10/13 19:28
 * @desc 线程池的使用
 */
public class ThreadPoolTest {
    @Test
    public void test01() throws Exception {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 20, 10, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(), new ThreadFactory() {
            int threadNum = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThread" + threadNum);
                threadNum++;
                return thread;
            }
        });
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


}
