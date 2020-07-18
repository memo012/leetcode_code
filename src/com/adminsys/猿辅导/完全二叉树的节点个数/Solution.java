package com.adminsys.猿辅导.完全二叉树的节点个数;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int width = queue.size();
            count++;
            for (int i = 0; i < width; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }
    /**
     * eft == right。这说明，左子树一定是满二叉树，
     * 因为节点已经填充到右子树了，左子树必定已经填满了。
     * 所以左子树的节点总数我们可以直接得到，是2^left - 1，
     * 加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
     * left != right。说明此时最后一层不满，
     * 但倒数第二层已经满了，可以直接得到右子树的节点个数。
     * 同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。
     */
    public int countLevels(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) return countLevels(root.right) + 1 << leftLevel;
        else return countLevels(root.left) + 1 << rightLevel;
    }
    public int countLevel(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

}