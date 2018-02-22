package cn.cy.data_struct.tree;

import javax.swing.tree.TreeNode;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by jiangyi on 2017/6/27.
 */
public class Main {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        Tree.Node root = tree.createNode("A");
        Tree.Node nodeB = tree.createNode("B");
        Tree.Node nodeC = tree.createNode("C");
        root.setLeft(nodeB);
        nodeB.setLeft(nodeC);
        Tree.Node nodeD = tree.createNode("D");
        root.setRight(nodeD);
        Tree.Node nodeE = tree.createNode("E");
        nodeD.setLeft(nodeE);
        Tree.Node nodeF = tree.createNode("F");
        nodeD.setRight(nodeF);

        System.out.println("前序遍历========");
        beforeOrder(root);
        System.out.println();
        System.out.println("中序遍历========");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历========");
        afterOrder(root);

    }

    public static void beforeOrder(Tree.Node node){
        System.out.print(node.getData());
        if(node.getLeft() != null){
            beforeOrder(node.getLeft());
        }
        if(node.getRight() != null){
            beforeOrder(node.getRight());
        }
    }

    public static void inOrder(Tree.Node node){

        if(node.getLeft() != null){
            inOrder(node.getLeft());
        }

        System.out.print(node.getData());

        if(node.getRight() != null){
            inOrder(node.getRight());
        }
    }

    public static void afterOrder(Tree.Node node){

        if(node.getLeft() != null){
            afterOrder(node.getLeft());
        }
        if(node.getRight() != null){
            afterOrder(node.getRight());
        }
        System.out.print(node.getData());
    }
}
