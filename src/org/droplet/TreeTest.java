package org.droplet;

import org.droplet.collection.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> c = new TreeNode<>('C');
        TreeNode<Character> d = new TreeNode<>('D');
        TreeNode<Character> e = new TreeNode<>('E');
        TreeNode<Character> f = new TreeNode<>('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
    }

    public static void preOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.element + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element);
    }

    public static void levelOrder(TreeNode<Character> root) {
        Queue<TreeNode<Character>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Character> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }

}
