package online.goudan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author 刘苟淡
 * @description 各种排序算法
 * @date 2020/9/27 11:02
 */
public class _04Sort各种排序算法 {
    private int n;
    private int[] arr;
    private long sum;

    @Before
    public void init() {
        arr = new int[]{45, 21, 63, 2, 1, 65, 33, 22, 71, 34, 20, 93, 26, 98, 32, 23, 21, 66, 9};
//        arr = new int[]{9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        n = arr.length;
//        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf("排序前:%s%n", Arrays.toString(arr));
        sum = 0;
        n = 10000000;
        arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
    }


    /**
     * 冒泡排序(Bubble Sort)
     * 原理:
     * （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
     * （2）这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉”到数组第
     * N-1 个位置。
     * （3）N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。
     */
    @Test
    public void bubbleSort() {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sum++;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序(Insert Sort)
     * 原理:
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     */
    @Test
    public void insertSort() {
        for (int i = 1; i < n; i++) {
            int insertVar = arr[i];
            int index = i - 1;
            while (index >= 0 && insertVar < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
                sum++;
            }
            arr[index + 1] = insertVar;
        }
    }

    /**
     * 快速排序(Quick Sort)
     * 原理:
     * 选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
     * 比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素。
     * 操作:
     * 从右往左找,找到比基准值小的索引,从左往右找,找到比基准值大的索引,然后交换位置,
     * 交换完成后,再接着从右往左找,找到比基准值小的索引,从左往右找,找到比基准值大的索引,交换位置...。
     * 最后,将基准值放在中间,再用递归分别排序基准左右边的
     */
    @Test
    public void quickSort() {
        sum += _04Util.qucikSort(arr, 0, n - 1);
    }

    /**
     * 希尔排序(Shell Sort)
     * 是对插入排序的一种优化
     * 增量(步长)变化是 arr.length/2 arr.length/2^2 arr.length/2^3 ... 1 最终为1;
     * 原理:
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列
     * 中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * 操作:
     * 1. 选择一个增量序列 t1，t2，…，tk，其中 ti>tj，tk=1；
     * 2. 按增量序列个数 k，对序列进行 k 趟排序；
     * 3. 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进
     * 行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长
     * 度。
     */
    @Test
    public void shellSort() {

        int step = n / 2;
        int index = step;
        while (step > 0) {
            while (index < n) {
                int insertVar = arr[index];
                int innerIndex = index - step;

                while (innerIndex >= 0 && insertVar < arr[innerIndex]) {
                    arr[innerIndex + step] = arr[innerIndex];
                    innerIndex -= step;
                    sum++;
                }
                sum++;
                arr[innerIndex + step] = insertVar;
                index++;
            }
            step /= 2;
        }

       /* //使用递归的实现
        _04Util.shellSort(arr, n / 2);*/

    }

    /**
     * 归并排序（Merge Sort)
     * 原理：
     * 将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列
     * 分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     */
    @Test
    public void mergeSort() {
        mergeSort(arr, 0, n - 1);
    }

    /**
     * 归并排序递归实现
     *
     * @param a
     * @param left
     * @param right
     */
    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;//分解
            mergeSort(a, left, middle);//治理
            mergeSort(a, middle + 1, right);
            merge(a, left, middle, right);//合并
        }
    }

    /**
     * 合并
     *
     * @param a
     * @param left
     * @param middle
     * @param right
     */
    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArray = new int[a.length];
        int rightStart = middle + 1;
        int tmp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while (left <= middle && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[rightStart++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while (left <= middle) {
            tmpArray[third++] = a[left++];
        }
        //如果右边还有数据......
        while (rightStart <= right) {
            tmpArray[third++] = a[rightStart++];
        }
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }


    @After
    public void destory() {
        System.out.printf("排序后:%s%n", Arrays.toString(arr));
        System.out.printf("数据操作次数:%d%n", sum);

    }
}
