package com.adminsys.strategic;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 08-58
 **/

public class StrategicFactory {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 0, 0, 0, 0};
    }

    public static void test(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return;
        }
        int[] c = new int[a.length + b.length];
        int i = 0, ia = 0, ib = 0;
        while (ia < a.length && ib < b.length) {
            if (a[ia] < b[ib]) {
                c[i++] = a[ia++];
            } else {
                c[i++] = b[ib++];
            }
        }
        while (ia < a.length) {
            c[i++] = a[ia++];
        }
        while (ib < b.length) {
            c[i++] = b[ib++];
        }
    }
}