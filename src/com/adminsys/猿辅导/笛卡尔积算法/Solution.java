package com.adminsys.猿辅导.笛卡尔积算法;

import java.util.*;
import java.lang.*;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/23 下午10:06
 **/
public class Solution {

    public static void descartes(
            List<List<String>> arr, int start, List<String> list, List<List<String>> lists
    ) {
        List<String> arrParams = arr.get(start);
        for (int i = 0; i < arrParams.size(); i++) {
            List<String> childList = new ArrayList<>(list);
            childList.add(arrParams.get(i));
            if (start == arr.size() - 1) {
                lists.add(new ArrayList<>(childList));
                continue;
            }
            descartes(arr, start + 1, childList, lists);
        }
    }


    private static List<List<String>> getDescartes(List<List<String>> list) {
        List<List<String>> returnList = new ArrayList<>();
        descartes(list, 0, new ArrayList<String>(), returnList);
        return returnList;
    }

    public static void main(String[] args) {
        List<List<String>> listData = new ArrayList<>();
        listData.add(Arrays.asList("note", "pro"));
        listData.add(Arrays.asList("4G", "8G"));
        listData.add(Arrays.asList("64", "128"));
        listData.add(Arrays.asList("标配", "低配", "高配"));
        List<List<String>> lisReturn = getDescartes(listData);
        System.out.println(lisReturn);
    }

}