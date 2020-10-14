package online.goudan;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenglongliu
 * @date 2020/10/13 19:49
 * @desc 队列的使用
 */
public class QueueTest {
    int i = 0;

    /**
     * 有界队列的使用
     */
    @Test
    public void test01() throws Exception {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(20);
        for (; i < 20; i++) {
            strings.put(String.valueOf(i));
        }
        System.out.println(strings);
        boolean flag = false;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        if (i % 3 == 0) {
                            Thread.sleep(2500L);
                            strings.put(String.valueOf(i++));
                        } else {
                            Thread.sleep(1000L);
                            strings.put(String.valueOf(i++));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        while (true) {
            String s = strings.take();
            if (s != null) {
                System.out.printf("time:%.2f,字符:%s%n", System.currentTimeMillis() % 1000000 / 1000f, s);
            } else {
                System.out.printf("time:%.2f,字符:%s%n", System.currentTimeMillis() % 1000000 / 1000f, s);
                break;
            }
        }
    }

    @Test
    public void test02(){
        Date date = new Date(1478188800000L);
        System.out.println(date);
        Date date1 = new Date(1530544308000L);
        System.out.println(date1);
    }
}
