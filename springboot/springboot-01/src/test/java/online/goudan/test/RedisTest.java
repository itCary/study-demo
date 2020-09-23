package online.goudan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 19:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {
        //字符串
        redisTemplate.boundValueOps("str").set("goudan");
        System.out.println("str = " + redisTemplate.opsForValue().get("str"));
        //hash 散列
        redisTemplate.boundHashOps("hash").put("name", "刘成龙");
        redisTemplate.boundHashOps("hash").put("age", 18);

        Set set = redisTemplate.boundHashOps("hash").keys();
        System.out.println("hash散列所有的域:" + set);
        List list = redisTemplate.boundHashOps("hash").values();
        System.out.println("hash散列所有的域值:" + list);


        //list列表
        redisTemplate.boundListOps("list").leftPush("c");
        redisTemplate.boundListOps("list").leftPush("b");
        redisTemplate.boundListOps("list").leftPush("c");
        list = redisTemplate.boundListOps("list").range(0, -1);
        System.out.println("列表的值:" + list);


        //set 集合
        redisTemplate.boundSetOps("set").add("a", "b", "c");
        set = redisTemplate.boundSetOps("set").members();
        System.out.println("集合的元素:" + set);

        //sorted_set 有序集合
        redisTemplate.boundZSetOps("zset").add("a", 30);
        redisTemplate.boundZSetOps("zset").add("b", 20);
        redisTemplate.boundZSetOps("zset").add("c", 10);
        set = redisTemplate.boundZSetOps("zset").range(0, -1);
        System.out.println("有序集合的元素:" + set);

    }
}
