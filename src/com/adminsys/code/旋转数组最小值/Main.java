package com.adminsys.code.旋转数组最小值;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-04 13-38
 **/

public class Main {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int mid = start;
        while (numbers[start] >= numbers[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (numbers[start] == numbers[mid] && numbers[end] == numbers[mid]) {
                return midInOrder(numbers, start, end);
            }
            if (numbers[mid] >= numbers[start]) {
                start = mid;
            }
            if (numbers[mid] <= numbers[end]) {
                end = mid;
            }
        }
        return numbers[mid];
    }

    private int midInOrder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}