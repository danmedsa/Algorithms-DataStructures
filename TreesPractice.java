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

    public void generateBinaryTree(int depth) {
        out.println("--- Generating Binary Tree ---");
        appendChildren(this.root, depth);
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

    public static void preOrderTraverse(TreeNode root){
        if (root == null) {
            return;
        }
        root.prettyPrint();
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);

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

    public void prettyPrint(){
        out.print("Visiting: ");

        if (this != null) {
            out.print(this.data + " |");

            if (this.left != null) {
                out.print(" Left - " + this.left.data);
            } else {
                out.print(" Left - (null)");
            }

            if (this.right != null) {
                out.print(" Right - " + this.right.data);
            } else {
                out.print(" Right - (null)");
            }
            out.println();
        }
    }
}

