package com.danielmedina;

import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.System.out;

class Tree {
    TreeNode root;

    public Tree(){
        out.println("--- Generating Tree Root ---");
        this.root = new TreeNode();
    }

    public TreeNode generateBinaryTree(int depth) {
        out.println("--- Generating Binary Tree ---");
        TreeNode root = new TreeNode();
        appendChildren(root, depth);
        return root;
    }

    private void appendChildren(TreeNode parent, int depth){
        out.println();
        if (depth == 0) {
            return;
        }

        TreeNode nodeLeft = new TreeNode();
        TreeNode nodeRight = new TreeNode();

        parent.left = nodeLeft;
        parent.right = nodeRight;
        out.println("--- Node: " + parent.data + " - Left: " + parent.left.data + " - Right: " + parent.right.data);
        appendChildren(nodeLeft, depth - 1);
        appendChildren(nodeRight, depth - 1);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(){
        int newData = abs((new Random()).nextInt() % 10);
        this.data = newData;
        out.println("--- New Node: " + this.data);

    }

    public static void preOrderTraverse(TreeNode root){
        if (root == null) {
            return;
        }

        out.print(root.data);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
}

