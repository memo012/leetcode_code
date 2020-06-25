package com.adminsys.tree;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-05-23 18-41
 **/

public class BSTree<K extends Comparable<K>, V> {

    private static final String BLACK = "black";
    private static final String RED = "red";

    private Node root;

    public Node getRoot() {
        return root;
    }

    static class Node<K extends Comparable<K>, V> {
        private Node parent;
        private Node left;
        private Node right;
        private String color;
        private K k;
        private V v;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Node() {
        }

        public Node(Node parent, Node left, Node right, String color, K k, V v) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.k = k;
            this.v = v;
        }
    }

    /**
     * 将节点颜色设置为黑色
     * @param node
     */
    private void setBlack(Node node) {
        if (node != null) {
            node.setColor(BLACK);
        }
    }

    /**
     * 将节点颜色设置为红色
     * @param node
     */
    private void setRed(Node node) {
        if (node != null) {
            node.setColor(RED);
        }
    }

    /**
     * 节点是否为红色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node != null) {
            return node.color.equals(RED);
        }
        return false;
    }

    /**
     * 节点是否为黑色
     *
     * @param node
     * @return
     */
    private boolean isBlack(Node node) {
        if (node != null) {
            return node.color.equals(BLACK);
        }
        return false;
    }


    /**
     * 返回节点父节点
     *
     * @param node
     * @return
     */
    private Node parentOf(Node node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    /**
     * 左旋方法
     * 左旋示意图：左旋x节点
     * p                   p
     * |                   |
     * x                   y
     * / \         ---->   / \
     * lx  y               x   ry
     * / \             / \
     * ly  ry          lx  ly
     * 1. 将Y的左节点赋值给X的右节点 且将X设置为Y左节点的父节点
     * 2. 当X节点的父节点不为空时，将X的父节点指向Y，且更新Y的父节点为X的父节点
     * 3. 将Y的左节点指向X，更新X的父节点为Y
     *
     * @param x
     */
    private void leftTo(Node x) {
        // 旋转节点的右节点
        Node y = x.right;
        // 将旋转节点的右节点的左节点赋值为旋转节点的左节点
        x.right = y.left;
        // 将X设置为Y左节点的父节点
        if (y.left != null) {
            y.left.parent = x;
        }

        if (x.parent != null) {
            // 不是根节点
            // 在左子节点
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                // 在右子节点
                x.parent.right = y;
            }
            // 更新Y的父节点为X的父节点
            y.parent = x.parent;
        } else {
            // 根节点
            this.root = x;
            this.root.parent = null;
        }

        // 将Y的左节点指向X，更新X的父节点为Y
        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋方法
     * 右旋示意图：右旋y节点
     * <p>
     * p                       p
     * |                       |
     * y                       x
     * / \          ---->      / \
     * x   ry                  lx  y
     * / \                         / \
     * lx  ly                      ly  ry
     * <p>
     * 右旋都做了几件事？
     * 1.将x的右子节点 赋值 给了 y 的左子节点 并且更新x的右子节点的父节点为 y
     * 2.将y的父节点（不为空时）指向x 更新x的父节点为y的父节点
     * 3.将x的右子节点指向y 更新y的父节点为x
     *
     * @param y
     */
    private void rightTo(Node y) {
        //
        Node x = y.left;
        // 将x的右子节点 赋值 给了 y 的左子节点
        y.left = x.right;
        // 更新x的右子节点的父节点为 y
        if (x.right != null) {
            x.right.parent = y;
        }
        // 更新x的父节点为y的父节点
        x.parent = y.parent;
        if (y.parent != null) {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            this.root = y;
            this.root.parent = null;
        }
        // 将x的右子节点指向y 更新y的父节点为x
        x.right = y;
        y.parent = x;
    }

    /**
     * 插入
     *
     * @param k
     * @param v
     */
    public void insert(K k, V v) {
        Node node = new Node();
        node.setK(k);
        node.setV(v);
        node.setColor(RED);
        insert(node);
    }

    private void insert(Node node) {
        Node parent = null;
        Node x = this.root;
        while (x != null) {
            parent = x;
            int cmp = node.k.compareTo(parent.k);
            if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                parent.setV(node.v);
                return;
            } else {
                x = x.left;
            }
        }

        node.parent = parent;
        if (parent != null) {
            if (node.k.compareTo(parent.k) > 0) {
                parent.right = node;
            } else {
                parent.left = node;
            }
        } else {
            this.root = node;
        }

        //插入之后需要进行修复红黑树，让红黑树再次平衡。
        insertFixUp(node);
    }

    /**
     * 插入后修复红黑树平衡的方法
     * |---情景1：红黑树为空树
     * |---情景2：插入节点的key已经存在
     * |---情景3：插入节点的父节点为黑色
     * <p>
     * 情景4 需要咱们去处理
     * |---情景4：插入节点的父节点为红色
     * |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
     * |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     * |---情景4.2.1：插入节点为其父节点的左子节点（LL情况）
     * |---情景4.2.2：插入节点为其父节点的右子节点（LR情况）
     * |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     * |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
     * |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）
     */
    private void insertFixUp(Node node) {
        // 父节点
        Node parent = parentOf(node);
        // 祖父节点
        Node gParent = parentOf(parent);
        if (parent != null && isRed(parent)) {
            //父节点是红色的，那么一定存在爷爷节点

            // 插入节点的父节点为祖父节点的左节点
            if (parent == gParent.left) {
                Node uncle = gParent.right;

                // 父节点和叔节点为红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gParent);
                    insertFixUp(gParent);
                    return;
                }

                // 叔叔节点不存在或存在且为黑色
                if (uncle == null || isBlack(uncle)) {

                    // LL模型
                    // 父节点->黑  祖父节点->红 以祖父为旋转节点右旋
                    if (node == parent.left) {
                        setBlack(parent);
                        setRed(gParent);
                        rightTo(gParent);
                    }

                    // LR 模型
                    // 以父节点为旋转节点->左旋
                    if (node == parent.right) {
                        leftTo(parent);
                        insertFixUp(parent);
                        return;
                    }
                }
            }

            // 插入节点的父节点为祖父节点的右节点
            if (parent == gParent.right) {
                Node uncle = gParent.left;

                // 父节点和叔叔节点为红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gParent);
                    insertFixUp(gParent);
                    return;
                }


                if (uncle == null || isBlack(uncle)) {

                    // 父节点为祖父节点的右节点
                    // RR模型 父节点->黑 祖父节点->红
                    if (node == parent.right){
                        setBlack(parent);
                        setRed(gParent);
                        leftTo(gParent);
                    }

                    // RL模型 父节点->黑 祖父节点->红
                    if (node == parent.left) {
                        rightTo(parent);
                        insertFixUp(parent);
                        return;
                    }

                }


            }


        }
        setBlack(this.root);
    }

}
