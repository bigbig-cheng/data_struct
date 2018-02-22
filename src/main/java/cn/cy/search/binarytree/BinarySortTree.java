package cn.cy.search.binarytree;

import cn.cy.data_struct.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyi on 2017/9/14.
 */
public class BinarySortTree<T extends Comparable> extends Tree{

    /**
     * 二叉排序树
     *      遍历
     */
    public List<T> ergodic(){
        List<T> rstList = new ArrayList<>();
        this.inOrder(this.getRoot(), rstList);
        return rstList;
    }
    private void inOrder(Node node, List rstList){

        if(node.getLeft() != null){
            inOrder(node.getLeft(), rstList);
        }

        rstList.add(node.getData());

        if(node.getRight() != null){
            inOrder(node.getRight(), rstList);
        }
    }


    /**
     * 二叉排序树查找
     * @param a
     * @return
     */
    public boolean search(T a){

        Tree.Node root = this.getRoot();
        if(root == null){
            return false;
        }

        return this.searchWithNode(a, root, new Tree.Node[1]);
    }

    /**
     * 二叉排序树
     *      按节点查找
     * @param a
     * @param node
     * @return
     */
    private boolean searchWithNode(T a, Tree<T>.Node node, Tree<T>.Node[] pointers){

        if(node == null){
            return false;
        }

        if(node.getData().compareTo(a) == 0){
            return true;
        }

        if(a.compareTo(node.getData()) < 0){
            pointers[0] = node;
            return searchWithNode(a, node.getLeft(), pointers);
        }

        if(a.compareTo(node.getData()) > 0){
            pointers[0] = node;
            return searchWithNode(a, node.getRight(), pointers);
        }

        return false;
    }

    /**
     * 二叉排序树插入
     */
    public boolean insert(T data){
        if(this.getRoot()==null){
            Tree<T>.Node root = this.createNode(data);
            this.setRoot(root);
            return true;
        }

        Tree<T>.Node[] pointers = new Tree.Node[1];
        boolean hasExisted = this.searchWithNode(data, this.getRoot(), pointers);
         if(!hasExisted){

            Tree<T>.Node newNode = new Tree().new Node(data);

            if(data.compareTo(pointers[0].getData()) > 0){
                pointers[0].setRight(newNode);
            }

            if(data.compareTo(pointers[0].getData()) < 0){
                pointers[0].setLeft(newNode);
            }

            return true;
        }
        return false;
    }

    /**
     * 删除操作
     * @param data
     * @return
     */
    public boolean delete(T data){

        boolean isLeftChild = false;
        Node current = this.getRoot();
        Node parent = null;

        while (data.compareTo(current.getData()) != 0){
            parent = current;
            if (data.compareTo(current.getData()) < 0){
                current = current.getLeft();
                isLeftChild = true;
            }else{
                current = current.getRight();
                isLeftChild = false;
            }
        }
        if (current == null){
            // 没有符合条件的节点
            return false;
        }

        // 无子节点
        if (current.getLeft()==null && current.getRight()==null){
            if (current == this.getRoot()){
                this.setRoot(null);
            }else if (isLeftChild){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        } else if ((current.getLeft()==null && current.getRight()!=null)){
            // 仅有右节点
            if (current == this.getRoot()){
                this.setRoot(current.getRight());
            }else if (isLeftChild){
                parent.setLeft(current.getRight());
            }else{
                parent.setRight(current.getRight());
            }
        } else if ((current.getLeft()!=null && current.getRight()==null)){
            // 仅有左节点
            if (current == this.getRoot()){
                this.setRoot(current.getLeft());
            }else if (isLeftChild){
                parent.setLeft(current.getLeft());
            }else{
                parent.setRight(current.getLeft());
            }
        }else{
            Node temp = current;
            // 向左,一路向右到底
            Node s = current.getLeft();
            while(s.getRight() != null){
                temp = s;
                s = s.getRight();
            }

            current.setData((T) s.getData());
            if(temp != current){
                temp.setRight(s.getLeft());
            }else{
                temp.setLeft(s.getLeft());
            }
        }
        return true;
    }

}
