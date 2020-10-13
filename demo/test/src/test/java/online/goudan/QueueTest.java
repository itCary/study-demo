package online.goudan;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author chenglongliu
 * @date 2020/10/13 19:49
 * @desc 队列的使用
 */
public class QueueTest {
    /**
     * 有界队列的使用
     */
    @Test
    public void test01() throws Exception {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(20);
        for (int i = 0; i < 20; i++) {
            strings.put("" + i);
        }
        System.out.println(strings);
    }
}
