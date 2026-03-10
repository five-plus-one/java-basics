package com.fiveplusone.homework01;

class Node {
    Integer key;
    Node left, right;

    public Node(Integer item) {
        this.key = item;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 向二叉搜索树中插入一个新节点。
     * @param key 要插入的键值
     * @throws IllegalArgumentException 如果键值为null或已存在
     */
    public void insert(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("不能向二叉树中插入null值。");
        }
        root = insertRec(root, key);
    }

    /**
     * 一个递归函数，用于在二叉搜索树中插入新键。
     */
    private Node insertRec(Node root, Integer key) {
        // 如果树为空，则返回一个新节点
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // 否则，沿着树向下递归
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        } else {
            // 此BST实现不允许重复键
            throw new IllegalArgumentException("不允许重复的键值 '" + key + "'。");
        }

        return root;
    }

    /**
     * 对二叉树进行前序遍历。
     */
    public void preorderTraversal() {
        preorderRec(root);
    }

    /**
     * 一个工具函数，用于执行BST的前序遍历。
     */
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        try {
            /*
                  50
               /     \
              30      70
             /  \    /  \
            20   40  60   80
            */
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            System.out.println("树的前序遍历为:");
            tree.preorderTraversal();
            System.out.println();

            // 测试重复键的异常
            System.out.println("\n尝试插入重复键 40...");
            tree.insert(40);

        } catch (IllegalArgumentException e) {
            System.err.println("捕获到预期的异常: " + e.getMessage());
        }

        try {
            // 测试null键的异常
            System.out.println("\n尝试插入null键...");
            tree.insert(null);
        } catch (IllegalArgumentException e) {
            System.err.println("捕获到预期的异常: " + e.getMessage());
        }
    }
}
