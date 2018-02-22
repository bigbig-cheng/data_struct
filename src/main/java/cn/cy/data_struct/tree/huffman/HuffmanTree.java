package cn.cy.data_struct.tree.huffman;

import java.util.*;

/**
 * Created by jiangyi on 2017/6/27.
 */
public class HuffmanTree<T> {

    private Node root;

    /**
     *
     * @param type
     *  1-前序遍历
     *  2-中序遍历
     *  3-后序遍历
     * @param node
     */
    public void ergodicHuffmanTree(int type, Node node){

        if(type == 1){
            System.out.print(node+", ");
        }
        if(node.getLeft() != null){
            ergodicHuffmanTree(type, node.getLeft());
        }
        if(type == 2){
            System.out.print(node+", ");
        }
        if(node.getRight() != null){
            ergodicHuffmanTree(type, node.getRight());
        }
        if(type == 3){
            System.out.print(node+", ");
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    class Node implements Comparable<Node>{

        public Node(int weight, T data){
            this.weight = weight;
            this.data = data;
        }

        private int weight; // 权重
        private T data;
        private Node parent;
        private Node left;
        private Node right;

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }

        /**
         * 是否是根节点
         * @return
         */
        public boolean isRoot(){
            return parent == null;
        }

        /**
         * 是否是左节点
         * @return
         */
        public boolean isLeft(){
            return parent!=null && this==parent.left;
        }

        /**
         * 是否是右节点
         * @return
         */
        public boolean isRight(){
            return parent!=null && this==parent.right;
        }

        /**
         * 是否是叶子结点
         * @return
         */
        public boolean isLeaf(){
            return left==null && right==null;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

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

        public String toString(){
            return this.data==null ? "NULL-"+weight : this.data.toString()+"-"+weight;
        }
    }


    public List<HuffmanTree<T>.Node> buildTree(Map<T, Integer> rateMap){

        List<HuffmanTree<T>.Node> leafNodeList = new ArrayList<>();
        if(rateMap==null || rateMap.isEmpty()){
            return leafNodeList;
        }

        Queue<HuffmanTree<T>.Node> queue = new PriorityQueue<>();
        for (T t : rateMap.keySet()) {
            HuffmanTree<T>.Node leafNode = this.new Node(rateMap.get(t), t);
            queue.add(leafNode);
            leafNodeList.add(leafNode);
        }

        // 遍历到只剩一个节点
        while(!queue.isEmpty() && queue.size()>1){
            // 获取队列最前面2个节点
            HuffmanTree.Node leftNode = queue.poll();
            HuffmanTree.Node rightNode = queue.poll();

            // 生成一个新树
            Integer newWeight = leftNode.getWeight()+rightNode.getWeight();
            HuffmanTree.Node newRoot = this.new Node(newWeight, null);
            newRoot.setLeft(leftNode);
            newRoot.setRight(rightNode);

            leftNode.setParent(newRoot);
            rightNode.setParent(newRoot);

            // 添加到队列
            queue.add(newRoot);
        }

        // 生成赫夫曼树
        this.setRoot(queue.poll());

        return leafNodeList;
    }

}
