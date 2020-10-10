package online.goudan;

import org.junit.Test;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/10/10 08:56
 */
public class PerformanceTest {
    /**
     * 三目运算符和 ifelse 效率测试
     */
    @Test
    public void test01() {
        //来点计算，用处不大。
        long sum = -1;
        //循环次数，有点大哦，自己悠着点调
        final long max = 1000000000L;
        //下面给出一个包含循环和计算的耗时统计，作为一个基础。后面的统计必然包含此部分时间
        long timeS = System.currentTimeMillis();
        for (long i = 0; i < max; i++) {
            sum = i + i;
        }
        long timeE = System.currentTimeMillis();
        long delta = timeE - timeS;

        //计算出一个布尔值，免得后面还要计算而占用时间，造成误差。
        boolean flag = sum > 0;
        //下面是If/Else（包含循环和计算）的耗时统计，真实耗时应当除去上面的基准值
        long timeS1 = System.currentTimeMillis();
        for (long i = 0; i < max; i++) {
            if (flag) {
                sum = i + i;
            } else {
                sum = i + i;
            }
        }
        long timeE1 = System.currentTimeMillis();
        long delta1 = timeE1 - timeS1;
        //这是真实的耗时计算
        long realIfElse = delta1 - delta;


        //下面是三目运算符（包含循环和计算）的耗时统计，真实耗时同样应当除去前面的基准值
        long timeS2 = System.currentTimeMillis();
        for (long i = 0; i < max; i++) {
            sum = flag ? i + i : i + i;
        }
        long timeE2 = System.currentTimeMillis();
        long delta2 = timeE2 - timeS2;
        //这是真实的耗时计算
        long realTri = delta2 - delta;

        //返回耗时比率，以反映效率差别
        double f = (double) realIfElse / realTri;
        System.out.printf("ifelse:%d%n", realIfElse);
        System.out.printf("tri:%d%n", realTri);
        System.out.printf("proportion:%f%n", f);
    }

    public static void main(String[] args) {
        long sum = -1;
        long max = 10000000000L;
        for (long i = 0; i < max; i++) {
            sum = i + i;
        }
        boolean flag = sum > 0;
        //ifelse
        long ifsTime = System.currentTimeMillis();
        for (long i = 0; i < max; i++) {
            if (flag) {
                sum = i + i;
            } else {
                sum = i + i;
            }
        }
        long ifeTime = System.currentTimeMillis();

        //三目
        for (long i = 0; i < max; i++) {
            sum = flag ? i + i : i + i;
        }
        long triETime = System.currentTimeMillis();
        System.out.printf("ifelse:%d%n", ifeTime - ifsTime);
        System.out.printf("tri:%d%n", triETime - ifeTime);
        System.out.printf("proportion:%f%n", (ifeTime - ifsTime) / (double) (triETime - ifeTime));
        System.out.printf("sum=%d", sum);
    }
}
