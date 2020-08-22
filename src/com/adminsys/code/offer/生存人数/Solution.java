package com.adminsys.code.offer.生存人数;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/2 下午4:30
 **/
public class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] lives = new int[102];
        for (int birthYear : birth) lives[birthYear - 1900]++;
        for (int deathYear : death) lives[deathYear - 1900 + 1]--;

        int[] preSum = new int[102];
        preSum[0] = lives[0];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + lives[i];

        int maxLives = -1;
        int minYear = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] > maxLives) {
                minYear = i + 1900;
                maxLives = preSum[i];
            }
        }
        return minYear;

    }
}
