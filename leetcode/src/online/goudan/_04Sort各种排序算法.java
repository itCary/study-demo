package online.goudan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 刘苟淡
 * @description 各种排序算法q
 * @date 2020/9/27 11:02
 */
public class _04Sort各种排序算法 {

    private int[] arr;
    private int n;

    @Before
    public void init() {
        arr = new int[]{45, 21, 63, 2, 1, 65, 33, 22, 71, 34, 20, 93, 26, 23, 21, 66, 9};
        System.out.println(Arrays.toString(arr));
        n = arr.length;
    }


    /**
     * 冒泡排序
     * 先将大的数移到后面
     */
    @Test
    public void test01() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }

    /**
     * 插入排序
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     */
    @Test
    public void test02() {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int insertVar = arr[i];
            for (int j = i; j > 0; j--) {
                sum++;
                if (insertVar < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = insertVar;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.printf("sum:%d%n", sum);
    }


    @After
    public void destory() {
        System.out.println(Arrays.toString(arr));
    }
}
