package com.study.basis.designpattern.composite.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }

    /**
     * DEMO
     * @param args
     */
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
    /**
     * https://blog.csdn.net/zhangerqing/article/details/8239539
     *
     * 组合模式有时又叫部分-整体模式，在处理类似树形结构的问题时比较方便
     * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
     */
}
