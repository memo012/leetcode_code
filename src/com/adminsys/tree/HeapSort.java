package com.adminsys.tree;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: qiang
 * @Description: 堆排序
 * @Create: 2020-02-12 13-08
 **/

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 34};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        int temp;
        // 分步完成
//        adjustHeap(arr, 1, arr.length);
        // 将无序列表构建成一个堆  根据升序降序需求选择大顶推或小顶推
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("第一次:" + Arrays.toString(arr));
        // 将堆顶元素与末尾元素交换 将最大元素"沉"到数组末端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素 反复执行调整+交换步骤 直到整个序列有序
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
            System.out.println("第一次:" + Arrays.toString(arr));
        }
        System.out.println("第一次:" + Arrays.toString(arr));
    }

    // 将一个数组调整成一个大顶推
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];// 先取出当前元素的值,保存在临时变量
        // 开始调整
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) { // 说明左子节点的值小于右子节点的值
                j++;// k指向右子节点
            }
            if (arr[j] > temp) { // 如果子节点大于父节点
                arr[i] = arr[j]; // 把较大的值赋给当前节点
                i = j;// i 指向 j 继续循环比较
            } else {
                break;
            }
        }
        // 当for 循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶(局部)
        arr[i] = temp;// 将temp值放到调整后的位置
    }


    public static void heapSortMemo(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void heapSortMemo(int[] arr) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapSortMemo(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapSortMemo(arr, 0, i);
        }
        System.out.println("第一次:" + Arrays.toString(arr));
    }

}
