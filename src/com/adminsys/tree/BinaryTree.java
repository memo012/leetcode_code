package com.adminsys.tree;

import java.util.*;

import static java.lang.Math.max;

/**
 * @Author: qiang
 * @Description: 二叉树题目
 * @Create: 2020-02-07 03-29
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 将数值传入构建
     *
     * @param data
     */
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    /**
     * 二叉树的层次遍历 II
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int width = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                TreeNode mid = queue.poll();
                list.add(mid.val);
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
            stack.push(list);
        }
        while (!stack.isEmpty()) {
            lists.add(stack.pop());
        }
        return lists;
    }

    private void insert(int datum) {
        Node node = new Node(datum);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (datum < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + "->");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }

    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    /**
     * 前序遍历 非递归
     */
    public void preOrder2() {
        this.preOrder2(this.root);
    }

    public void preOrder2(Node localRoot) {
        Stack<Node> stack = new Stack<>();
        Node node = localRoot;
        stack.push(node);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.data + "->");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    /**
     * 中续遍历 --  非遍历
     */
    public void inOrder2() {
        this.inOrder2(this.root);
    }

    public void inOrder2(Node localRoot) {
        Stack<Node> stack = new Stack<>();
        Node node = localRoot;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.data + "->");
                node = pop.right;
            }
        }
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + "->");
            inOrder(localRoot.right);
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    public void postOrder2() {
        this.postOrder2(this.root);
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + "->");
        }
    }

    public void postOrder2(Node localRoot) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<Node> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。
        Node node = localRoot;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(node);
                stack2.push(left);
                node = node.left;
            }
            while (!stack.isEmpty() && stack2.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.print(stack.pop().data + "->");
            }
            if (!stack.isEmpty() && stack2.peek() == left) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                node = stack.peek().right;
            }
        }
    }

    /**
     * 二叉树的宽度
     * 二叉树宽度求的是包含节点树最多的一层 可以用队列维持每一层的节点个数
     * 进而得到最大的节点个数
     *
     * @param node
     * @return
     */
    public int maxWidth(Node node) {
        int maxWith = 1, with;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            with = queue.size();
            maxWith = max(maxWith, with);
            for (int i = 0; i < with; i++) {
                Node oldNode = queue.poll();
                if (oldNode.left != null) {
                    queue.add(oldNode.left);
                }
                if (oldNode.right != null) {
                    queue.add(oldNode.right);
                }
            }
        }
        return maxWith;
    }

    /**
     * 特定深度节点链表
     */
    class Solution {

        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }
            List<ListNode> res = new ArrayList<>();
            TreeNode node = tree;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int width;
                width = queue.size();
                ListNode head = null;
                ListNode tail = null;
                for (int i = 0; i < width; i++) {
                    TreeNode mid = queue.poll();
                    if (i == 0) {
                        head = tail = new ListNode(mid.val);
                    } else {
                        ListNode cur = new ListNode(mid.val);
                        tail = tail.next = cur;
                    }

                    if (mid.left != null) {
                        queue.add(mid.left);
                    }

                    if (mid.right != null) {
                        queue.add(mid.right);
                    }
                }
                res.add(head);
            }
            return res.toArray(new ListNode[0]);
        }
    }

    /**
     * 二叉树的右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode mid = queue.poll();
                if (i == size - 1) {
                    list.add(mid.val);
                }
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
        }
        return list;
    }

    /**
     * 找树左下角的值
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = root.val;
        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                TreeNode mid = queue.poll();
                if (i == 0) count = mid.val;
                if (mid.left != null) queue.add(mid.left);
                if (mid.right != null) queue.add(mid.right);
            }
        }
        return count;
    }

    /**
     * 二叉树的锯齿形层次遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        int count = 0;
        while (!queue.isEmpty()) {
            int width = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < width; i++) {
                TreeNode mid = queue.poll();
                if (!flag) {
                    list.addLast(mid.val);
                } else {
                    list.addFirst(mid.val);
                }
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
            flag = !flag;
            count++;
            lists.add(list);
        }
        return lists;
    }

    /**
     * 二叉树中所有距离为 K 的结点
     * 类似层序遍历思想
     */
    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs1(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> set = new HashSet<>();
        set.add(target);

        int dis = 0;

        while (!queue.isEmpty()) {
            int width = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                TreeNode node = queue.poll();
                if (dis == K) {
                    list.add(node.val);
                } else {
                    if (node.left != null && !set.contains(node.left)) {
                        set.add(node.left);
                        queue.add(node.left);
                    }
                    if (node.right != null && !set.contains(node.right)) {
                        set.add(node.right);
                        queue.add(node.right);
                    }
                    TreeNode pre = parent.get(node);
                    if (pre != null && !set.contains(pre)) {
                        set.add(pre);
                        queue.add(pre);
                    }
                }
            }
            if (dis == K) {
                return list;
            }
            dis++;
        }

        return new ArrayList<>();
    }

    public void dfs1(TreeNode node, TreeNode pre) {
        if (node != null) {
            parent.put(node, pre);
            dfs1(node.left, node);
            dfs1(node.right, node);
        }
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            depth++;
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                Node td = queue.poll();
                if (td.left == null && td.right == null) {
                    flag = true;
                    break;
                }
                if (td.left != null) {
                    queue.add(td.left);
                }
                if (td.right != null) {
                    queue.add(td.right);
                }
            }
            if (flag) {
                break;
            }
        }
        return depth;
    }

    /**
     * 二叉树打印所有和为某值的路径
     *
     * @return
     */
    public ArrayList<ArrayList<Integer>> findPath(int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        preorder(root, target, ans, path);// 开始前序遍历
        return ans;
    }

    private void preorder(Node root, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path) {
        path.add(root.data);
        target -= root.data;
        if (target == 0 && root.left == null && root.right == null) { //如果target在减去结点值后为0 并恰好到了叶节点 说明目标路径找到
            ans.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            preorder(root.left, target, ans, path);
        }
        if (root.right != null) {
            preorder(root.right, target, ans, path);
        }
        path.remove(path.size() - 1);
    }

    /**
     * 求和路径
     */
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        path(root, sum);
        return count;
    }

    public void path(TreeNode root, int sum) {
        if (root == null) return;
        preOrder(root, sum);
        path(root.left, sum);
        path(root.right, sum);
    }

    public void preOrder(TreeNode root, int target) {
        if (root == null) return;
        target -= root.val;
        if (target == 0)
            count++;
        if (root.left != null)
            preOrder(root.left, target);
        if (root.right != null)
            preOrder(root.right, target);
    }

    /**
     * 二叉搜索树的第K个节点
     *
     * @param
     */
    public Node KthNode(Node root, int k) {
        Node node = root;
        if (node == null || k == 0) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        int count = 0;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node mid = stack.pop();
                count++;
                if (count == k) {
                    return mid;
                }
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    public int TreeDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Node node = root;
        int left = TreeDepth(node.left);
        int right = TreeDepth(node.right);
        return (left > right) ? (left + 1) : (right + 1);
    }

    /**
     * 判断是否为平衡二叉树
     *
     * @return
     */
    public boolean isBalance(Node root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalance(root.left)
                && isBalance(root.right);
    }

    public int depth(Node root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    /**
     * 叶子相似的树
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    public void dfs(TreeNode node, LinkedList<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

    /**
     * 删点成林
     */
    Set<Integer> set;
    List<TreeNode> list;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for (Integer i : to_delete) set.add(i);
        list = new ArrayList<>();
        dfs(root, true);
        return list;
    }

    public boolean dfs(TreeNode node, boolean isAdd) {
        if (node == null) return false;
        if (set.contains(node.val)) {
            if (dfs(node.left, true)) node.left = null;
            if (dfs(node.right, true)) node.right = null;
            return true;
        }
        if (isAdd) list.add(node);

        if (dfs(node.left, false)) node.left = null;
        if (dfs(node.right, false)) node.right = null;
        return false;
    }

    /**
     * 二叉树的堂兄弟节点
     */
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        dfsCousins(root, null);
        boolean flagx = false;
        boolean flagy = false;
        TreeNode nodex = null;
        TreeNode nodey = null;
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                TreeNode mid = queue.poll();
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
                if (x == mid.val) {
                    flagx = true;
                    nodex = map.get(mid);
                }
                if (y == mid.val) {
                    flagy = true;
                    nodey = map.get(mid);
                }
            }
            if (flagx && flagy && nodex != nodey) {
                return true;
            }
            flagx = flagy = false;
            nodex = nodey = null;
        }
        return false;
    }

    public void dfsCousins(TreeNode node, TreeNode pre) {
        if (node != null) {
            map.put(node, pre);
            dfsCousins(node.left, node);
            dfsCousins(node.right, node);
        }
    }

    /**
     * 两个节点的最低公共祖先  -- 二叉搜索树
     *
     * @return
     */
    public Node smallBoss(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        Node node = root;
        while (node != null) {
            if (node.data < node1.data && node.data < node2.data) {
                node = node.right;
            } else if (node.data > node1.data && node.data > node2.data) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(Node root) {
        Node node = root;
        if (node == null) {
            return true;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node node1 = node.left;
        Node node2 = node.right;
        while (node1 != null || node2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (node1 != null && node2 != null) {
                stack1.push(node1);
                stack2.push(node2);
                node1 = node1.left;
                node2 = node2.right;
            }
            if (node1 != null || node2 != null) {
                return false;
            }
            node1 = stack1.pop();
            node2 = stack2.pop();
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.right;
            node2 = node2.left;
        }
        return true;
    }

    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    /**
     * 从前序和中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public Node buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (Integer val : inorder) {
            idx_map.put(val, index++);
        }
        return helper(0, inorder.length);
    }

    private Node helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int root_val = preorder[pre_idx];
        Node root = new Node(root_val);
        Integer integer = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(left, integer);
        root.right = helper(integer + 1, right);
        return root;
    }

    /**
     * 验证二叉树的前序序列化
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        //1. 如果字符串有且仅有一个#，直接true
        if (split.length == 1 && "#".equals(split[0])) {
            return true;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (stack.isEmpty()) {
                stack.push(split[i]);
            } else if ("#".equals(split[i])) {
                while (!stack.isEmpty() && "#".equals(stack.peek())) {
                    stack.pop();
                    while (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
                if (i != split.length - 1) {
                    stack.push(split[i]);
                }
            } else {
                stack.push(split[i]);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Node head = root;
        if (head == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int with = queue.size();
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < with; i++) {
                Node mid = queue.poll();
                list1.add(mid.data);
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
            list.add(list1);
        }
        return list;
    }

    /**
     * 两数之和 IV - 输入 BST
     *
     * @param root
     * @param k
     * @return
     */
    ArrayList<Integer> arrayList = new ArrayList<>();

    public boolean findTarget(Node root, int k) {
        Node head = root;
        if (head == null) {
            return false;
        }
        inorder(head);
        int i = 0;
        int j = arrayList.size() - 1;
        while (i != j) {
            int mid = arrayList.get(i) + arrayList.get(j);
            if (mid == k) {
                return true;
            } else if (mid > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inorder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            arrayList.add(localRoot.data);
            inOrder(localRoot.right);
        }
    }

    /**
     * 普通二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        ArrayList<Node> listp = new ArrayList<>();
        ArrayList<Node> listq = new ArrayList<>();
        getNodePathp(root, p, listp);
        getNodePathp(root, q, listq);
        Collections.reverse(listp);
        Collections.reverse(listq);
        int min = Math.min(listp.size(), listq.size());
        Node n = null;
        for (int i = 0; i < min; i++) {
            if (listp.get(i) == listq.get(i)) {
                n = listp.get(i);
            }
        }
        return n;
    }

    private boolean getNodePathp(Node roots, Node p, ArrayList<Node> list) {
        if (roots == null) {
            return false;
        }
        if (roots == p) {
            list.add(roots);
            return true;
        }
        if (getNodePathp(roots.left, p, list) || getNodePathp(roots.right, p, list)) {
            list.add(roots);
            return true;
        }
        return false;
    }

    /**
     * 树的子结构
     */
    public boolean HasSubtree(Node father, Node season) {
        if (season == null) {
            return false;
        }
        if (father == null && season != null) {
            return false;
        }
        boolean blag = false;
        if (father.data == season.data) {
            blag = isSubTree(father, season);
        }
        if (!blag) {
            blag = HasSubtree(father.left, season);
            if (!blag) {
                blag = HasSubtree(father.right, season);
            }
        }
        return blag;
    }

    private boolean isSubTree(Node father, Node season) {
        if (season == null) {
            return true;
        }
        if (father == null && season != null) {
            return false;
        }
        if (father.data == season.data) {
            return isSubTree(father.left, season.left) && isSubTree(father.right, season.right);
        } else {
            return false;
        }
    }


    /**
     * 从上到下打印二叉树
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                TreeNode mid = queue.poll();
                list.add(mid.val);
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 无序数组创建平衡二叉树
     *
     * @param num
     * @return
     */
    public Node sortedArrayToBSTTwo(int[] num) {
        if (Objects.isNull(num)) {
            return null;
        }
        Arrays.sort(num);
        return ArrayToBSTTwo(num, 0, num.length - 1);
    }

    private Node ArrayToBSTTwo(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(num[mid]);
        node.left = ArrayToBSTTwo(num, 0, mid - 1);
        node.right = ArrayToBSTTwo(num, mid + 1, end);
        return node;
    }
    /**
     *  最小高度树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) return null;
        int mid = length / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, 0, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, length - 1);
        return node;
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    /**
     * 判断是否为完全二叉树
     *
     * @return
     */
    public boolean isCBT() {
        Node node = root;
        if (node == null) {
            return false;
        }
        Node leftNode = null;
        Node rightNode = null;
        boolean flag = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node mid = queue.poll();
            leftNode = mid.left;
            rightNode = mid.right;
            if ((leftNode == null && rightNode != null) || (flag && (leftNode != null || rightNode != null))) {
                return false;
            }
            if (leftNode != null) {
                queue.add(leftNode);
            }
            if (rightNode != null) {
                queue.add(rightNode);
            } else {
                flag = true;
            }
        }
        return true;
    }

    /**
     * 判断满二叉树
     *
     * @return
     */
    public boolean isFullTree() {
        Node node = root;
        if (node == null) {
            return false;
        }
        Node leftNode = null;
        Node rightNode = null;
        boolean flag = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node mid = queue.poll();
            leftNode = mid.left;
            rightNode = mid.right;
            if ((leftNode != null && rightNode == null) ||
                    (leftNode == null && rightNode != null) ||
                    (flag && (leftNode != null || rightNode != null))) {
                return false;
            }
            if (leftNode != null && rightNode != null) {
                queue.add(leftNode);
                queue.add(rightNode);
                continue;
            }
            if (leftNode == null) {
                flag = true;
            }
        }
        return true;
    }

    /**
     * 完全二叉树节点个数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int left = countLevel(node.left);
        int right = countLevel(node.right);
        if (left == right) {
            return countNodes(node.right) + (1 << left);
        } else {
            return countNodes(node.left) + (1 << right);
        }

    }

    public int countLevel(TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    /**
     * 二叉树直径
     */
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }

    /**
     * 二叉树的所有路径
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        return list;
    }

    public void dfs(TreeNode root, List<String> list, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                list.add(path);
            } else {
                path += "->";
                dfs(root.left, list, path);
                dfs(root.right, list, path);
            }
        }
    }


}