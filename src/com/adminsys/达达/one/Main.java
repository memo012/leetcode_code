package com.adminsys.达达.one;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/5 下午7:48
 **/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int temp = sc.nextInt();
            topQueue(temp);
        }
    }
    public static void topQueue(int num) {
        LinkedList<Integer> last = new LinkedList<>();
        for (int i = 1; i <= num; i++) last.addLast(i);

        LinkedList<Integer> first = new LinkedList<>();
        while (!last.isEmpty()) {
            int temp = last.removeFirst();
            last.addLast(temp);
            temp = last.removeFirst();
            first.addLast(temp);
        }

        int[] res = new int[num];
        for (int i = 1; i <= num; i++) {
            int t = first.removeFirst();
            res[t - 1] = i;
        }

        for (int i = 0; i < num; i++) {
            if (i == num - 1) System.out.println(res[i]);
            else System.out.print(res[i]+" ");
        }


    }
}
