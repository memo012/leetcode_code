package com.adminsys.code.连通网络的操作次数;

class Solution {
    int[] father;
    int[] sz;
    int num;
    public void initUF(int n) {
        father = new int[n];
        sz = new int[n];
        num = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            sz[i] = 1;
        }
    }
    public int find(int p) {
        if (p != father[p]) {
            p = find(father[p]);
        }
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        num--;
        if (sz[i] < sz[j]) {
            father[i] = j;
            sz[j] += sz[i];
        }else{
            father[j] = i;
            sz[i] += sz[j];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        initUF(n);

        int remain = 0;
        for (int[] in : connections) {
            int p = in[0], q = in[1];
            if (find(p) == find(q)) {
                remain++;
                continue;
            }
            union(p, q);
        }

        int cnt = num - 1;
        if (cnt > remain) return - 1;
        return cnt;

    }
}