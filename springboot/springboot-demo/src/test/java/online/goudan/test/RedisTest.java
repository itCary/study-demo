package online.goudan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author chenglongliu
 * @date 2021/4/14 16:46
 * @desc RedisTest
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {

        System.out.println(redisTemplate.opsForValue().get("str"));
    }


    @Test
    public void testGetAllKey() {
        //hash散列
        redisTemplate.boundHashOps("h_key").put("name", "黑马");
        redisTemplate.boundHashOps("h_key").put("age", 13);
        //获取所有域对应的值
        Set set = redisTemplate.boundHashOps("h_key").keys();
        System.out.println("hash散列所有的域：" + set);
        List list = redisTemplate.boundHashOps("h_key").values();
        System.out.println("hash散列所有的域值：" + list);
        //list列表
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("b");
        redisTemplate.boundListOps("l_key").leftPush("a");
        list = redisTemplate.boundListOps("l_key").range(0, -1);
        System.out.println("列表的值：" + list);

        //set集合
        redisTemplate.boundSetOps("set_key").add("a", "b", "c");
        set = redisTemplate.boundSetOps("set_key").members();
        System.out.println("集合的元素：" + set); //sorted set有序集合
        redisTemplate.boundZSetOps("z_key").add("a", 30);
        redisTemplate.boundZSetOps("z_key").add("b", 20);
        redisTemplate.boundZSetOps("z_key").add("c", 10);
        set = redisTemplate.boundZSetOps("z_key").reverseRange(0, -1);
        System.out.println("有序集合的元素：" + set);
    }

    @Test
    public void testDeleteKeys() {
        Boolean b = redisTemplate.expire("z_key", 5000L, TimeUnit.MILLISECONDS);
        System.out.println(b);
        while (true) {

        }
    }
}
