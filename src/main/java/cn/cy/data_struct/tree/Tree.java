package cn.cy.data_struct.tree;

/**
 * Created by jiangyi on 2017/6/27.
 */
public class Tree<T> {

    private Node root;

    public class Node{

        public Node(T data){
            this.data = data;
        }

        private T data;
        private Node left;
        private Node right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
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
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node createNode(T data){
        return this.new Node(data);
    }
}
