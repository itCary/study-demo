package online.goudan;

import java.util.Arrays;

/**
 * @author chenglongliu
 * @date 2020/10/15 14:20
 * @desc 04的附件
 */
public class _04Util {

    /**
     * 快速排序
     *
     * @param arr   需要排序的数组
     * @param start 开始时最左边的索引=0
     * @param end   开始时最右边的索引=arr.length-1
     */
    public static int qucikSort(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        int temp, left, right, key, sum;
        sum = 0;
        //从左到右的指针
        left = start;
        //从右到左的指针
        right = end;
        //基准
        key = arr[start];

        //循环完成后,比基准值小的都在左边了,比基准值大的都在右边了
        while (left < right) {
            //从右往左找到第一个比基准值小的数
            while (left < right && key <= arr[right]) {
                right--;
            }
            //从左往右找到第一个比基准值大的数
            while (left < right && key >= arr[left]) {
                left++;
            }
            //将这两个数交换位置
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                sum++;
            }
        }

        //将基准值交换到中间
        arr[start] = arr[left];
        arr[left] = key;

        sum++;
        sum += qucikSort(arr, start, left - 1);
        sum += qucikSort(arr, left + 1, end);
        return sum;
    }


    public static void shellSort(int[] arr, int step) {
        if (step == 0) {
            return;
        }
        int n = arr.length;
        int index = step;
        while (index < n) {
            int insertVar = arr[index];
            int innerIndex = index - step;
            while (innerIndex >= 0 && insertVar < arr[innerIndex]) {
                arr[innerIndex + step] = arr[innerIndex];
                innerIndex -= step;
            }
            arr[innerIndex + step] = insertVar;
            index++;
        }
        shellSort(arr, step / 2);
    }
}
